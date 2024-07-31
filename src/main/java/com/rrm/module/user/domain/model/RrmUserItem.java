package com.rrm.module.user.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 用户项目关联类.
 *
 * @author TWL 2024/7/31 10:52
 * @since 1.0
 */
@Data
public class RrmUserItem {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer UserId;
    private Integer ItemId;
}
