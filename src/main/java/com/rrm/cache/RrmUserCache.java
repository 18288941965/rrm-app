package com.rrm.cache;

import lombok.Data;

import java.io.Serializable;

/**
 * rrm_user
 */
@Data
public class RrmUserCache implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 角色
     */
    private Byte role;

    /**
     * 权限
     */
    private String permission;

    /**
     * 项目代码
     */
    private String itemCode;

    private static final long serialVersionUID = 1L;
}