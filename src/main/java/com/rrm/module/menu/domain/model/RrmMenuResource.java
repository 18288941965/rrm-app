package com.rrm.module.menu.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rrm.base.ModelInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 菜单（元素）资源关联表
 * rrm_menu_resource
 */
@Getter
@Setter
public class RrmMenuResource extends ModelInfo implements Serializable {
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
     * 资源ID
     */
    private String resourceId;

    /**
     * 类型
     */
    private String type;

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