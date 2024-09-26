package com.rrm.module.role.domain.vo;

import com.rrm.module.role.domain.model.RrmRole;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色管理
 * rrm_role
 */
@Getter
@Setter
public class RrmRoleVO extends RrmRole {

    private String typeName;

    private Integer bindMenuCount;

    private Integer bindElementCount;

}