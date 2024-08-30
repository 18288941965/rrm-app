package com.rrm.module.role.domain.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色管理
 * rrm_role
 */
@Data
public class RrmRole implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 等级（权限从小到大）
     */
    private Integer level;

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
     * 顺序号
     */
    private Integer sortOrder;

    /**
     * 状态（1：启用，0：停用）
     */
    private Byte status;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 项目代码
     */
    private String itemCode;

    private static final long serialVersionUID = 1L;
}