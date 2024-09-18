package com.rrm.module.menu.dto;

import lombok.Data;

/**
 * 菜单（元素）资源关联表
 * rrm_menu_resource
 */
@Data
public class RrmMenuResourceDTO {

    /**
     * 菜单ID
     */
    private String menuId;

    /**
     * 资源ID
     */
    private String resourceId;

    /**
     * 项目代码
     */
    private String itemCode;
}