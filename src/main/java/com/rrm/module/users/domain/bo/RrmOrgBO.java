package com.rrm.module.users.domain.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * 任职机构
 * rrm_org
 */
@Getter
@Setter
public class RrmOrgBO {
    /**
     * 主键
     */
    private String id;

    /**
     * 机构代码
     */
    private String code;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 默认登录（1：是 ，0：否）
     */
    private Byte defaultLogin;

    /**
     * 绑定角色统计
     */
    private long roleCount;
}