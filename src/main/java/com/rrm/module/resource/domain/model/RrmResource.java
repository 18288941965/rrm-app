package com.rrm.module.resource.domain.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 资源管理
 * rrm_resource
 */
@Data
public class RrmResource implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 类名
     */
    private String className;

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
    private String name;

    /**
     * 资源类型(字典)
     */
    private String type;

    /**
     * 授权码
     */
    private Integer authCode;

    /**
     * 创建人
     */
    private Integer createdBy;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新人
     */
    private Integer updatedBy;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 状态(1：启用，0：停用)
     */
    private Byte status;

    /**
     * 项目代码
     */
    private String itemCode;

    private static final long serialVersionUID = 1L;
}