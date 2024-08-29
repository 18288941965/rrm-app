package com.rrm.module.menu.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 菜单组件
 * rrm_menu_element
 */
@Data
public class RrmMenuElement implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 菜单ID
     */
    private String menuId;

    /**
     * 控件名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 创建人
     */
    private Integer createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新人
     */
    private Integer updatedBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 状态（1：可用，0：不可用）
     */
    private Byte status;

    private static final long serialVersionUID = 1L;
}