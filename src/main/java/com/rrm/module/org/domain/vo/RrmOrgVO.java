package com.rrm.module.org.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 机构管理树结构
 * rrm_menu
 */
@Data
public class RrmOrgVO {

     /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 机构代码
     */
    private String code;

    /**
     * 上级机构代码
     */
    private String parentCode;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 机构名称简称
     */
    private String abbrName;

    /**
     * 机构类型（dic_org_type）
     */
    private String type;

    /**
     * 是否删除（注销）（1：是，0：否）
     */
    private Byte isDeleted;

    /**
     * 删除（注销）时间
     */
    private LocalDateTime deletedAt;

    // 子菜单
    private List<RrmOrgVO> children = new ArrayList<>();
}