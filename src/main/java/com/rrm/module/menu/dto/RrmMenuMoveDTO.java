package com.rrm.module.menu.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 类描述.
 *
 * @author TWL 2024/8/28 10:42
 * @since 1.0
 */
@Data
public class RrmMenuMoveDTO {

    private List<String> moveIds;

    private String parentId;

    private String updatedBy;

    private LocalDateTime updatedAt;
}
