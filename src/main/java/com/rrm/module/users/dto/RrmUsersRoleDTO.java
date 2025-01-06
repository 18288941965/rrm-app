package com.rrm.module.users.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 用户角色关联表
 * rrm_users_role
 */
@Getter
@Setter
public class RrmUsersRoleDTO {

    /**
     * 用户ID
     */
    private String usersId;

    /**
     * 角色ID
     */
    private List<String> roleIdList;

    /**
     * 机构ID
     */
    private String orgId;

}