package com.rrm.module.users.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * rrm_users_org
 */
@Data
public class RrmUsersOrg implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 用户ID
     */
    private String usersId;

    /**
     * 机构ID
     */
    private String orgId;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 项目代码
     */
    private String itemCode;

    /**
     * 默认登录（1：是 ，0：否）
     */
    private Byte defaultLogin;

    private static final long serialVersionUID = 1L;
}