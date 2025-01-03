package com.rrm.module.user.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rrm.base.ModelInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * rrm_user
 */
@Getter
@Setter
public class RrmUser extends ModelInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 描述说明
     */
    private String description;

    private static final long serialVersionUID = 1L;

    /**
     * 覆盖字段
     */
    @TableField(exist = false)
    private String itemCode;
}