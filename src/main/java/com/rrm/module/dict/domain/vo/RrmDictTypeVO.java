package com.rrm.module.dict.domain.vo;

import lombok.Data;

/**
 * 字典项返回页面类.
 *
 * @author TWL 2024/8/12 11:14
 * @since 1.0
 */
@Data
public class RrmDictTypeVO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 字典类型编码
     */
    private String typeCode;

    /**
     * 字典类型名称
     */
    private String typeName;

    /**
     * 描述
     */
    private String description;

    /**
     * 字典子项统计
     */
    private Integer itemCount;
}
