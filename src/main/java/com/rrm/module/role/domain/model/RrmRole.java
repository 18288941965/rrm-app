package com.rrm.module.role.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rrm.base.ModelInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 角色管理
 * rrm_role
 */
@Getter
@Setter
public class RrmRole extends ModelInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 等级（权限从小到大）
     */
    private Integer level;

    /**
     * 顺序号
     */
    private Integer sortOrder;

    /**
     * 状态（1：启用，0：停用）
     */
    private Byte status;

    /**
     * 角色描述
     */
    private String description;

    private static final long serialVersionUID = 1L;
}