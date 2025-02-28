package com.rrm.base;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 类描述.
 *
 * @author TWL 2024/8/30 17:30
 * @since 1.0
 */
@Data
public class ModelInfo {

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 项目代码
     */
    private String itemCode;
}
