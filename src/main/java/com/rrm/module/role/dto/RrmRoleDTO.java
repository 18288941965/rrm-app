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
     * 等级（权限从小到大）
     */
    private Integer level;


    private String itemCode;

}