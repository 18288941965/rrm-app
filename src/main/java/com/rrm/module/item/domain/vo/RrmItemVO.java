package com.rrm.module.item.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 选择项目数据展示.
 *
 * @author TWL 2024/7/31 11:28
 * @since 1.0
 */
@Data
public class RrmItemVO {

    private Integer userId;
    private Integer itemId;
    private String itemName;
    private String itemCode;
    private LocalDateTime createTime;
    private String username;
}
