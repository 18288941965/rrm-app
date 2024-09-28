package com.rrm.module.user.dto;

import lombok.Data;

/**
 * 用户项目关联类.
 *
 * @author TWL 2024/7/31 10:52
 * @since 1.0
 */
@Data
public class RrmUserItemDTO {

    private Integer id;
    private Integer UserId;
    private String itemCode;
}
