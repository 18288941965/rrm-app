package com.rrm.module.menu.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rrm.base.ModelInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 菜单组件
 * rrm_menu_element
 */
@Getter
@Setter
public class RrmMenuElement extends ModelInfo implements Serializable {
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
     * 状态（1：可用，0：不可用）
     */
    private Byte status;

    private static final long serialVersionUID = 1L;
}