package com.rrm.module.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PathPatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@RestController
@RequestMapping("/scanner")
public class EndpointScanner {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping
    public void scanEndpoints() {
        RequestMappingHandlerMapping requestMappingHandlerMapping =
                applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();

        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : map.entrySet()) {
            RequestMappingInfo info = entry.getKey();
            HandlerMethod method = entry.getValue();

            // 获取请求路径和请求方法类型
            PathPatternsRequestCondition pathPatternsCondition = info.getPathPatternsCondition();
            String patterns = pathPatternsCondition.toString();
            String methods = info.getMethodsCondition().toString();

            // 获取Controller类名和方法名
            String className = method.getBeanType().getName();
            String methodName = method.getMethod().getName();

            // 输出扫描到的接口信息
            System.out.println("Class: " + className);
            System.out.println("Method: " + methodName);
            System.out.println("Patterns: " + patterns);
            System.out.println("Methods: " + methods);
            System.out.println("--------------------------------");
        }
    }
}
