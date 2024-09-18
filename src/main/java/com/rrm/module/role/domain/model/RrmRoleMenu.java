package com.rrm.module.role.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rrm.base.ModelInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色菜单（元素）关联表
 * rrm_role_menu
 */
@Getter
@Setter
public class RrmRoleMenu extends ModelInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 菜单或元素ID
     */
    private String menuId;

    /**
     * 类型
     */
    private String type;

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