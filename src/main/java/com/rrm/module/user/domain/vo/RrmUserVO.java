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
     * 新密码
     */
    private String newPassword;

    /**
     * 备注
     */
    private String comment;

}