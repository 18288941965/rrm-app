package com.rrm.module.item.domain.vo;

import com.rrm.module.user.domain.model.RrmUser;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 选择项目数据展示.
 *
 * @author TWL 2024/7/31 11:28
 * @since 1.0
 */
@Data
public class RrmItemVO {

    private Integer id;
    private String itemName;
    private String itemCode;
    private LocalDateTime createTime;
    private Integer userId;

    private List<RrmUser> userList;
    private Integer loginId;
}
