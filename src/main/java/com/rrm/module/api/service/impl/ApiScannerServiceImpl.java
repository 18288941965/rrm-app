package com.rrm.module.api.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.rrm.annotations.PermissionRequired;
import com.rrm.module.api.domain.bo.ApiScannerBO;
import com.rrm.module.api.dto.ApiScannerDTO;
import com.rrm.module.api.service.ApiScannerService;
import com.rrm.module.resource.domain.model.RrmResource;
import com.rrm.module.resource.service.RrmResourceService;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 接口扫描类.
 *
 * @author TWL 2024/10/30 16:48
 * @since 1.0
 */
@Service
public class ApiScannerServiceImpl implements ApiScannerService {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private RrmResourceService rrmResourceService;

    private final static String SCANNER_PACKAGE = "com.rrm.module";

    /**
     * 过滤调不在扫描包内的类
     * @param map 原始数据
     * @return 过滤后的数据
     */
    private Map<RequestMappingInfo, HandlerMethod> filterByPackage(
            Map<RequestMappingInfo, HandlerMethod> map){

        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getBeanType().getName().startsWith(SCANNER_PACKAGE))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * 获取类上的描述和授权码
     *  swagger 的 ApiOperation 注解获取类描述
     *  自定义的 PermissionRequired 注解获取授权码
     * @param classMap 结果
     * @param map 扫描的类
     * @param microservice 微服务名
     */
    private void getClassDescriptionAndAuthCode(
            Map<String, ApiScannerBO> classMap,
            Map<RequestMappingInfo, HandlerMethod> map,
            String microservice) {

        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : map.entrySet()) {
            HandlerMethod method = entry.getValue();
            // 类的全路径
            String fullyQualifiedName = method.getBeanType().getName();
            // 去重
            if (classMap.containsKey(fullyQualifiedName)) {
                continue;
            }
            Class<?> controllerClass = method.getBeanType();
            if (controllerClass.isAnnotationPresent(ApiOperation.class)) {
                ApiOperation aAnnotation = controllerClass.getAnnotation(ApiOperation.class);
                PermissionRequired pAnnotation = controllerClass.getAnnotation(PermissionRequired.class);

                String classAnnotationValue = aAnnotation == null ? microservice : aAnnotation.value();
                String authCode = pAnnotation == null ? PermissionRequired.AuthCodeEnum.AUTH.getCode() : pAnnotation.value().getCode();
                classMap.put(fullyQualifiedName, new ApiScannerBO(classAnnotationValue, authCode));
            }
        }
    }

    /**
     * 把接口构建为对象
     * @param resourceList 结果
     * @param map 扫描到的接口
     * @param classMap 扫描到的类及详细信息
     */
    private void bindRrmResource(
            List<RrmResource> resourceList,
            Map<RequestMappingInfo, HandlerMethod> map,
            Map<String, ApiScannerBO> classMap){

        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : map.entrySet()) {
            // 方法
            HandlerMethod method = entry.getValue();
            // 全路径类名
            String fullyQualifiedName = method.getBeanType().getName();

            RequestMappingInfo info = entry.getKey();

            ApiOperation annotation = method.getMethod().getAnnotation(ApiOperation.class);
            // 方法说明
            String methodAnnotationValue = annotation == null ? "METHOD-RRM" : annotation.value();

            // 获取请求路径和请求方法类型
            String methodPath = "";
            if (info.getPatternsCondition() != null) {
                methodPath = info.getPatternsCondition().getPatterns().iterator().next();
            } else if (info.getPathPatternsCondition() != null) {
                methodPath = info.getPathPatternsCondition().getDirectPaths().iterator().next();
            }

            if (StrUtil.isBlank(methodPath)) {
                continue;
            }

            // 请求方式
            String requestMethod = info.getMethodsCondition().getMethods().iterator().next().toString();

            ApiScannerBO apiScannerBO = classMap.get(fullyQualifiedName);

            Class<?> beanType = method.getBeanType();
            String className = beanType.getSimpleName();
            String packageName = beanType.getPackage().getName();


            RrmResource resource = new RrmResource();
            resource.setStatus((byte)1);
            // bindUserUtil.bindCreateUserInfo(resource);

            resource.setServiceName("RRM");
            resource.setPackageName(packageName);
            resource.setClassName(className);
            resource.setMethodName(method.getMethod().getName());
            resource.setRequestPath(methodPath);
            resource.setRequestMethod(requestMethod);
            resource.setResourceName(apiScannerBO.getAnnotationValue()+"-"+methodAnnotationValue);
            resource.setResourceType("01");
            resource.setAuthCode(apiScannerBO.getAuthCode());
            resource.setEnvironment("01");
            resource.setId(DigestUtil.md5Hex(methodPath+requestMethod+resource.getItemCode()));
            resourceList.add(resource);
        }
    }

    @Override
    public ResultVO<Void> run(ApiScannerDTO apiScannerDTO) {
        RequestMappingHandlerMapping requestMappingHandlerMapping =
                applicationContext.getBean(RequestMappingHandlerMapping.class);

        //----------1. 获取所有类上的接口（spring boot 的获取方法）
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();

        //----------2. 过滤调不在扫描包内的类
        map = filterByPackage(map);

        //----------3. 获取类的详情 【key 类全路径，value 类的基本信息】
        Map<String, ApiScannerBO> classMap = new HashMap<>();
        getClassDescriptionAndAuthCode(classMap, map, apiScannerDTO.getMicroservice());

        //----------4. 获取接口的详情
        List<RrmResource> resourceList = new ArrayList<>();
        bindRrmResource(resourceList, map, classMap);

        //----------5. 入库
        rrmResourceService.batchInsertResource(resourceList);
        return ResultVO.success();
    }
}
