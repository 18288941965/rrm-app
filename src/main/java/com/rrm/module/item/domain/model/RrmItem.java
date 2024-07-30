package com.rrm.module.item.domain.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 权限系统-项目管理
 * rrm_item
 */
@Data
@TableName("rrm_item")
public class RrmItem implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 项目编号
     */
    private String itemCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createUser;

    private static final long serialVersionUID = 1L;
}