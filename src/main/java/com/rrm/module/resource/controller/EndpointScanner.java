package com.rrm.module.resource.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.rrm.annotations.PermissionRequired;
import com.rrm.module.resource.domain.model.RrmResource;
import com.rrm.module.resource.service.RrmResourceService;
import com.rrm.util.BindUserUtil;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApiOperation("资源扫描")
@RestController
@RequestMapping("/scanner")
public class EndpointScanner {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private BindUserUtil bindUserUtil;

    @Autowired
    private RrmResourceService rrmResourceService;

    private final static String scannerPackage = "com.rrm.module";

    @Data
    static class EndpointScannerBO{
        private String annotationValue;
        private String authCode;

        public EndpointScannerBO(String annotationValue, String authCode) {
            this.annotationValue = annotationValue;
            this.authCode = authCode;
        }
    }

    @GetMapping
    @ApiOperation("扫描系统资源")
    public ResultVO<Void> scanEndpoints() {
        RequestMappingHandlerMapping requestMappingHandlerMapping =
                applicationContext.getBean(RequestMappingHandlerMapping.class);

        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();

        // 获取类上的注释名称
        Map<String, EndpointScannerBO> classMap = new HashMap<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : map.entrySet()) {
            HandlerMethod method = entry.getValue();
            String fullyQualifiedName = method.getBeanType().getName();
            if (classMap.containsKey(fullyQualifiedName) || !fullyQualifiedName.startsWith(scannerPackage)) {
                continue;
            }
            Class<?> controllerClass = method.getBeanType();
            if (controllerClass.isAnnotationPresent(ApiOperation.class)) {
                ApiOperation annotation = controllerClass.getAnnotation(ApiOperation.class);
                PermissionRequired pAnnotation = controllerClass.getAnnotation(PermissionRequired.class);
                String classAnnotationValue = annotation == null ? "CLASS-RRM" : annotation.value();
                String authCode = pAnnotation == null ? PermissionRequired.AuthCodeEnum.AUTH.getCode() : pAnnotation.value().getCode();
                classMap.put(fullyQualifiedName, new EndpointScannerBO(classAnnotationValue, authCode));
            }
        }

        List<RrmResource> resourceList = new ArrayList<>();

        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : map.entrySet()) {
            // 验证是否是扫描范围内的包
            HandlerMethod method = entry.getValue();
            // 类名
            String fullyQualifiedName = method.getBeanType().getName();
            if (!fullyQualifiedName.startsWith(scannerPackage)) {
                continue;
            }

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

            EndpointScannerBO endpointScannerBO = classMap.get(fullyQualifiedName);

            Class<?> beanType = method.getBeanType();
            String className = beanType.getSimpleName();
            String packageName = beanType.getPackage().getName();


            RrmResource resource = new RrmResource();
            resource.setStatus((byte)1);
            bindUserUtil.bindCreateUserInfo(resource);

            resource.setServiceName("RRM");
            resource.setPackageName(packageName);
            resource.setClassName(className);
            resource.setMethodName(method.getMethod().getName());
            resource.setRequestPath(methodPath);
            resource.setRequestMethod(requestMethod);
            resource.setResourceName(endpointScannerBO.getAnnotationValue()+"-"+methodAnnotationValue);
            resource.setResourceType("01");
            resource.setAuthCode(endpointScannerBO.getAuthCode());
            resource.setEnvironment("01");
            resource.setId(DigestUtil.md5Hex(methodPath+requestMethod+resource.getItemCode()));
            resourceList.add(resource);
        }

        ResultVO<Integer> integerResultVO = rrmResourceService.batchInsertResource(resourceList);
        return ResultVO.success();
    }
}
