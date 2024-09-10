package com.rrm.module.users.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rrm.base.ModelInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 外部用户信息
 * rrm_users
 */
@Getter
@Setter
public class RrmUsers extends ModelInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     *  性别 （dic_user_gender）
     */
    private String gender;

    /**
     * 民族 （dic_user_nation）
     */
    private String nation;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 出生日期
     */
    private LocalDateTime dateOfBirth;

    /**
     * 联系电话
     */
    private String phoneNumber;

    /**
     * 头像（base64）
     */
    private String avatar;

    /**
     * 任职机构代码
     */
    private String orgCode;

    /**
     * 任职机构名称
     */
    private String orgName;

    /**
     * 用户类型（dic_user_type）
     */
    private String type;

    /**
     *  用户描述
     */
    private String description;

    /**
     * 账户状态（1：活跃，-1：锁定、0：禁用）
     */
    private Byte accountStatus;

    /**
     *  注册时间
     */
    private LocalDateTime registrationDate;

    /**
     * 最近登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 登录失败次数
     */
    private Byte failedLoginAttempts;

    /**
     * 登录次数
     */
    private Integer loginCount;

    /**
     * 审核状态（-1：审核中，1：审核通过，0：审核不通过）
     */
    private Byte approvalStatus;

    /**
     *  审核时间
     */
    private LocalDateTime approvalAt;

    /**
     * 是否删除（注销）(1：是，0：否)
     */
    private Byte isDeleted;

    /**
     * 删除（注销时间）
     */
    private LocalDateTime deletedAt;

    /**
     * 扩展字段
     */
    private String extendedField;

    /**
     * 扩展字段2
     */
    private String extendedField2;

    /**
     * 项目代码 
     */
    private String itemCode;

    private static final long serialVersionUID = 1L;

}