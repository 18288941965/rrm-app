package com.rrm.module.menu.domain.vo;

import com.rrm.module.menu.domain.model.RrmMenu;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 接入系统菜单管理
 * rrm_menu
 */
@Getter
@Setter
public class RrmMenuVO extends RrmMenu {

    private String typeName;

    private String terminalName;

    private String netTypeName;

    private long childrenCount;

    // 子菜单
    private List<RrmMenuVO> children = new ArrayList<>();
}