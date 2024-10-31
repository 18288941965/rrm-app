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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.time.LocalDateTime;
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

    // 扫描包
    private final static String SCANNER_PACKAGE = "com.rrm.module";
    // 类描述为空-替换值
    private final static String CLASS_DESCRIPTION  = "CLASS-DESCRIPTION-UNDEFINED";
    // 接口描述为空-替换值
    private final static String METHOD_DESCRIPTION  = "METHOD-DESCRIPTION-UNDEFINED";

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
     *  1. ApiOperation 注解获取类描述
     *  2. PermissionRequired 注解获取授权码
     * @param classMap 结果
     * @param map 扫描的类
     */
    private void getClassDescriptionAndAuthCode(
            Map<String, ApiScannerBO> classMap,
            Map<RequestMappingInfo, HandlerMethod> map) {

        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : map.entrySet()) {
            HandlerMethod method = entry.getValue();
            // 类的全路径
            String fullyQualifiedName = method.getBeanType().getName();
            // 去重
            if (classMap.containsKey(fullyQualifiedName)) {
                continue;
            }
            Class<?> controllerClass = method.getBeanType();
            ApiScannerBO bo = new ApiScannerBO();
            bo.setAnnotationValue(getClassDescription(controllerClass));
            bo.setAuthCode(getClassAuthCode(controllerClass));

            // TODO 这里可以用相同的方式获取类上的其他注解信息，需要在ApiScannerBO增加相应的属性记录
            classMap.put(fullyQualifiedName, bo);
        }
    }

    /**
     * 获取类上的授权码
     * 1. PermissionRequired 从注解获取
     * @param controllerClass 类详情
     * @return 授权码
     */
    private String getClassAuthCode(Class<?> controllerClass) {
        PermissionRequired pAnnotation = null;
        if (controllerClass.isAnnotationPresent(PermissionRequired.class)) {
            pAnnotation = controllerClass.getAnnotation(PermissionRequired.class);
        }
        return pAnnotation == null ? PermissionRequired.AuthCodeEnum.AUTH.getCode() : pAnnotation.value().getCode();
    }

    /**
     * 获取类上的描述
     * 1. ApiOperation 从注解获取
     * @param controllerClass 类详情
     * @return 类描述
     */
    private String getClassDescription(Class<?> controllerClass) {
        ApiOperation aAnnotation = null;
        if (controllerClass.isAnnotationPresent(ApiOperation.class)) {
            aAnnotation = controllerClass.getAnnotation(ApiOperation.class);
        }
        return aAnnotation == null ? CLASS_DESCRIPTION : aAnnotation.value();
    }

    /**
     * 获取方法描述
     * 1. ApiOperation 从注解上获取
     * @param method 方法详情
     * @return 描述
     */
    private String getMethodDescription(HandlerMethod method){
        ApiOperation annotation = method.getMethod().getAnnotation(ApiOperation.class);
        return annotation == null ? METHOD_DESCRIPTION : annotation.value();
    }

    /**
     * 获取方法上的授权码
     * 1. PermissionRequired 从注解上获取
     * @param method 方法详情
     * @return 授权码
     */
    private String getMethodAuthCode(HandlerMethod method){
        PermissionRequired pAnnotation = method.getMethod().getAnnotation(PermissionRequired.class);
        return pAnnotation == null ? null : pAnnotation.value().getCode();
    }

    /**
     * 获取方法的访问路径
     * @param info 访问配置
     * @return 接口路径
     */
    private String getRequestPath(RequestMappingInfo info){
        if (info.getPatternsCondition() != null) {
            return info.getPatternsCondition().getPatterns().iterator().next();
        } else if (info.getPathPatternsCondition() != null) {
            return info.getPathPatternsCondition().getDirectPaths().iterator().next();
        }
        return null;
    }

    /**
     * 获取方法的运行环境[字典: dic_res_environment]
     * 1. 从注解获取，开发中。。。。
     * @param method 方法详情
     * @return 环境
     */
    private String getEnvironment(HandlerMethod method) {
        return "01";
    }

    /**
     * 获取方法的类型[字典: dic_res_type]
     * 1. 从注解获取，开发中。。。。
     * @param method 方法详情
     * @return 环境
     */
    private String getResourceType(HandlerMethod method) {
        return "01";
    }

    /**
     * 把接口构建为对象
     * 1. ApiOperation 注解获取方法描述
     * @param resourceList 结果
     * @param map 扫描到的接口
     * @param classMap 扫描到的类及详细信息
     */
    private void bindRrmResource(
            List<RrmResource> resourceList,
            Map<RequestMappingInfo, HandlerMethod> map,
            Map<String, ApiScannerBO> classMap){

        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : map.entrySet()) {
            HandlerMethod handlerMethod = entry.getValue();
            RequestMappingInfo requestMappingInfo = entry.getKey();

            // 获取方法描述
            String methodAnnotationValue = getMethodDescription(handlerMethod);
            // 获取请求路径
            String requestPath = getRequestPath(requestMappingInfo);
            if (StrUtil.isBlank(requestPath)) {
                continue;
            }
            // 获取请求方式
            String requestMethod = requestMappingInfo.getMethodsCondition().getMethods().iterator().next().toString();
            // 类的基本信息
            ApiScannerBO apiScannerBO = classMap.get(handlerMethod.getBeanType().getName());
            Class<?> beanType = handlerMethod.getBeanType();
            // 获取方法上的授权码
            String methodAuthCode = getMethodAuthCode(handlerMethod);

            RrmResource resource = new RrmResource();
            resource.setPackageName(beanType.getPackage().getName());
            resource.setClassName( beanType.getSimpleName());
            resource.setMethodName(handlerMethod.getMethod().getName());
            resource.setRequestPath(requestPath);
            resource.setRequestMethod(requestMethod);
            resource.setResourceName(apiScannerBO.getAnnotationValue()+"-"+methodAnnotationValue);
            resource.setAuthCode(methodAuthCode == null ? apiScannerBO.getAuthCode() : methodAuthCode);
            resource.setId(DigestUtil.md5Hex(requestPath+requestMethod+resource.getItemCode()));

            resource.setResourceType(getResourceType(handlerMethod));
            resource.setEnvironment(getEnvironment(handlerMethod));

            resourceList.add(resource);
        }
    }

    @Override
    @Transactional
    public ResultVO<Void> run(ApiScannerDTO apiScannerDTO) {
        RequestMappingHandlerMapping requestMappingHandlerMapping =
                applicationContext.getBean(RequestMappingHandlerMapping.class);

        //----------1. 获取所有类上的接口（spring boot 的获取方法）
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();

        //----------2. 过滤调不在扫描包内的类
        map = filterByPackage(map);

        //----------3. 获取类的详情 【key 类全路径，value 类的基本信息】
        Map<String, ApiScannerBO> classMap = new HashMap<>();
        getClassDescriptionAndAuthCode(classMap, map);

        //----------4. 获取接口的详情
        List<RrmResource> resourceList = new ArrayList<>();
        bindRrmResource(resourceList, map, classMap);

        //----------5. 设置数据的基本信息
        LocalDateTime createdAt = LocalDateTime.now();
        resourceList.forEach(resource -> {
            resource.setStatus((byte)1);
            resource.setCreatedBy(apiScannerDTO.getCreatedBy());
            resource.setCreatedAt(createdAt);
            resource.setItemCode(apiScannerDTO.getItemCode());
            resource.setServiceName(apiScannerDTO.getServiceName());
        });

        //----------6. 删除历史数据
        rrmResourceService.batchDeleteResource(apiScannerDTO);

        //----------7. 入库
        rrmResourceService.batchInsertResource(resourceList);
        return ResultVO.success();
    }
}
