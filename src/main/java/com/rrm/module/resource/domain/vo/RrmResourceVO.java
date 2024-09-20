package com.rrm.module.resource.domain.vo;

import com.rrm.base.ModelInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * 资源管理
 */
@Getter
@Setter
public class RrmResourceVO extends ModelInfo {
    /**
    * 主键
    */
    private String id;

    /**
    * 服务名称
    */
    private String serviceName;

    /**
    * 包名
    */
    private String packageName;

    /**
    * 类名
    */
    private String className;

    /**
    * 方法名
    */
    private String methodName;

    /**
    * 请求路径
    */
    private String requestPath;

    /**
    * 请求方式
    */
    private String requestMethod;

    /**
    * 资源名称
    */
    private String resourceName;

    /**
    * 资源类型(字典)
    */
    private String resourceType;

    /**
    * 授权码
    */
    private String authCode;

    /**
    * 资源环境（dev,production）
    */
    private String environment;

    /**
    * 状态(1：启用，0：停用)
    */
    private Byte status;

    private String resourceTypeName;
    private String environmentName;
    private String authCodeName;

}