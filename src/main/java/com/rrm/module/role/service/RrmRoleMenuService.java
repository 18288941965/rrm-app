package com.rrm.module.role.service;

import com.rrm.module.role.domain.model.RrmRoleMenu;
import com.rrm.vo.ResultVO;

/**
 * 角色菜单（元素）关联.
 *
 * @author TWL 2024/7/30 8:56
 * @since 1.0
 */
public interface RrmRoleMenuService {

    ResultVO<String> createRoleMenu(RrmRoleMenu rrmRoleMenu);

}
