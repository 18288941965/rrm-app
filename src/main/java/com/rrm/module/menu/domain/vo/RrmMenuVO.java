package com.rrm.module.menu.domain.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 接入系统菜单管理
 * rrm_menu
 */
@Data
public class RrmMenuVO {
    /**
     * 主键
     */
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

    // 菜单类型名称
    private String typeName;

    /**
     * 状态(1:有效, 0:无效)
     */
    private Byte status;

    // 子菜单
    private List<RrmMenuVO> children = new ArrayList<>();
}