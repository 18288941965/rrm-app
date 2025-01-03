package com.rrm.module.role.domain.vo;

import com.rrm.module.role.domain.model.RrmRole;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色管理
 * rrm_role
 */
@Getter
@Setter
public class RrmRoleVO extends RrmRole {

    private String typeName;

    private String terminalName;

    private String netTypeName;

    private Integer bindMenuCount;

    private Integer bindElementCount;

    private List<RrmRoleVO> children = new ArrayList<>();;

}