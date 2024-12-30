package com.rrm.module.item.domain.vo;

import com.rrm.module.user.domain.model.RrmUser;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 项目VO.
 *
 * @author TWL 2024/7/31 11:28
 * @since 1.0
 */
@Data
public class RrmItemVO {

    private String id;
    private String itemName;
    private String itemCode;
    private LocalDateTime createdAt;
    private String createdBy;

    private List<RrmUser> userList;
    private String loginId;
}
