package com.rrm.module.user.domain.vo;

import lombok.Data;

/**
 * rrm_user
 */
@Data
public class RrmUserVO {
    /**
     * 主键
     */
    private Integer id;

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

    /**
     * 备注
     */
    private String comment;

}