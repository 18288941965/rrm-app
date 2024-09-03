package com.rrm.module.item.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.rrm.base.ModelInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 项目DO
 */
@Getter
@Setter
@TableName("rrm_item")
public class RrmItem extends ModelInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 项目名称
     */
    private String itemName;

    private static final long serialVersionUID = 1L;
}