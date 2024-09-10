package com.rrm.module.org.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rrm.base.ModelInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 任职机构
 * rrm_org
 */
@Getter
@Setter
public class RrmOrg extends ModelInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 机构代码
     */
    private String code;

    /**
     * 上级机构代码
     */
    private String parentCode;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 机构名称简称
     */
    private String abbrName;

    /**
     * 机构类型（dic_org_type）
     */
    private String type;

    /**
     * 是否删除（注销）（1：是，0：否）
     */
    private Byte isDeleted;

    /**
     * 删除（注销）时间
     */
    private LocalDateTime deletedAt;

    /**
     * 扩展字段
     */
    private String extendedField;

    /**
     * 扩展字段2
     */
    private String extendedField2;

    private static final long serialVersionUID = 1L;
}