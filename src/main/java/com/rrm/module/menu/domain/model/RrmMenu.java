package com.rrm.module.menu.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 接入系统菜单管理
 * rrm_menu
 */
@Data
public class RrmMenu implements Serializable {
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
    private String visibility;

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
    private String pageCache;

    /**
     * 版本号
     */
    private String version;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 关联的项目
     */
    private String itemCode;

    /**
     * 状态(1:有效, 0:无效)
     */
    private Byte status;

    private static final long serialVersionUID = 1L;
}