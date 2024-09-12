package com.rrm.module.dict.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rrm.base.ModelInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * rrm_dict_entry
 */
@Getter
@Setter
public class RrmDictEntry extends ModelInfo implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 字典项编码
     */
    private String entryCode;

    /**
     * 字典项名称
     */
    private String entryName;

    /**
     * 字典类型代码
     */
    private String typeCode;

    /**
     * 父级字典项ID
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer sortOrder;

    /**
     * 状态(1:启用, 0:禁用)
     */
    private Byte status;

    /**
     * 描述
     */
    private String description;

    private static final long serialVersionUID = 1L;
}