package com.rrm.module.role.dto;

import com.rrm.util.PageBase;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色管理
 * rrm_role
 */
@Getter
@Setter
public class RrmRoleDTO extends PageBase {

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 终端
     */
    private String terminal;

    /**
     * 网络类型
     */
    private String netType;

    private String itemCode;

}