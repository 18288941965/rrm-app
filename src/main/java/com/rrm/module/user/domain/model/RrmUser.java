package com.rrm.module.user.domain.model;

import java.io.Serializable;
import lombok.Data;

/**
 * rrm_user
 */
@Data
public class RrmUser implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private Byte role;

    /**
     * 权限
     */
    private String permission;

    private static final long serialVersionUID = 1L;
}