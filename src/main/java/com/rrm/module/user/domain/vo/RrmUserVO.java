package com.rrm.module.user.domain.vo;

import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.module.user.domain.model.RrmUser;
import lombok.Data;

import java.util.List;

/**
 * rrm_user
 */
@Data
public class RrmUserVO {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 新密码
     */
    private String newPassword;

    /**
     * 描述说明
     */
    private String description;

    /**
     * 创建者
     */
    private Integer createdBy;

    /**
     * 用户关联的项目
     */
    private List<RrmItem> itemList;

    /**
     * 登录用户ID
     */
    private Integer loginId;
}