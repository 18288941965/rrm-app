package com.rrm.module.user.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rrm.base.ModelInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户项目关联类.
 *
 * @author TWL 2024/7/31 10:52
 * @since 1.0
 */
@Getter
@Setter
public class RrmUserItem extends ModelInfo implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer UserId;

    @TableField(exist = false)
    private Integer updatedBy;

    @TableField(exist = false)
    private LocalDateTime updatedAt;
}
