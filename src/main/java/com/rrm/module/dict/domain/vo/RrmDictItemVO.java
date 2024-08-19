package com.rrm.module.dict.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class RrmDictItemVO {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 字典项编码
     */
    private String itemCode;

    /**
     * 字典项名称
     */
    private String itemName;

    /**
     * 字典类型ID
     */
    private Long typeId;

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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    // 父字典项名称
    private String parentItemName;

    // 状态名称
    private String statusName;

}