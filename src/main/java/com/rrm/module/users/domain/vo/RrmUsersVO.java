package com.rrm.module.users.domain.vo;

import com.rrm.module.users.domain.bo.RrmOrgBO;
import com.rrm.module.users.domain.model.RrmUsers;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 外部用户信息
 * rrm_users
 */
@Getter
@Setter
public class RrmUsersVO extends RrmUsers {

    /**
     *  性别 （dic_user_gender）
     */
    private String genderName;

    /**
     * 民族 （dic_user_nation）
     */
    private String nationName;

    /**
     * 用户类型（dic_user_type）
     */
    private String typeName;

    /**
     * 关联机构列表
     */
    private List<RrmOrgBO> orgList;

}