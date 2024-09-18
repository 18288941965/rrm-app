package com.rrm.module.users.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.rrm.base.ModelInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
     * 更新人
     */
    @TableField(exist = false)
    private Integer updatedBy;

    /**
     * 更新时间
     */
    @TableField(exist = false)
    private LocalDateTime updatedAt;

    private static final long serialVersionUID = 1L;
}