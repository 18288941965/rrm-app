package com.rrm.module.users.domain.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.rrm.base.ModelInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户角色关联表
 * rrm_users_role
 */
@Getter
@Setter
public class RrmUsersRole extends ModelInfo implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 用户ID
     */
    private String usersId;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 机构ID
     */
    private String orgId;

    /**
     * 更新人
     */
    @TableField(exist = false)
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField(exist = false)
    private LocalDateTime updatedAt;

    private static final long serialVersionUID = 1L;
}