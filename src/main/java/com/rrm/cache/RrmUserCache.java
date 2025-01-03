package com.rrm.cache;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户缓存对象
 */
@Data
public class RrmUserCache implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 账号
     */
    private String username;

    /**
     * 项目代码
     */
    private String itemCode;

    /**
     * 登录token
     */
    private String token;

    private static final long serialVersionUID = 1L;
}