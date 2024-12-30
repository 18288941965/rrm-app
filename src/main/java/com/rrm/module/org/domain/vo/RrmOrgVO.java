package com.rrm.module.org.domain.vo;

import com.rrm.module.org.domain.model.RrmOrg;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 机构管理树结构
 * rrm_menu
 */
@Getter
@Setter
public class RrmOrgVO extends RrmOrg {

    private String typeName;

    private String statusName;

    // 子菜单
    private List<RrmOrgVO> children = new ArrayList<>();
}