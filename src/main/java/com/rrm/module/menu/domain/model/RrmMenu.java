package com.rrm.module.menu.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rrm.base.ModelInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 接入系统菜单管理
 * rrm_menu
 */
@Getter
@Setter
public class RrmMenu extends ModelInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 父菜单ID
     */
    private String parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单排序
     */
    private Integer sortOrder;

    /**
     * 菜单可见性
     */
    private Byte visibility;

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 菜单类型（dic_menu_type）
     */
    private String type;

    /**
     * 跳转方式
     */
    private String target;

    /**
     * 页面名称（页面name属性）
     */
    private String pageName;

    /**
     * 页面是否缓存（1：是，0：否）
     */
    private Byte pageCache;

    /**
     * 版本号
     */
    private String version;

    /**
     * 状态（1：启用 ，0：停用）
     */
    private Byte status;

    /**
     * 终端
     */
    private String terminal;

    /**
     * 网络类型
     */
    private String netType;

    private static final long serialVersionUID = 1L;
}