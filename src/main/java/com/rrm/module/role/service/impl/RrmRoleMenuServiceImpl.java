package com.rrm.module.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rrm.module.menu.domain.vo.RrmMenuVO;
import com.rrm.module.menu.mapper.RrmMenuMapper;
import com.rrm.module.role.domain.model.RrmRoleMenu;
import com.rrm.module.role.mapper.RrmRoleMenuMapper;
import com.rrm.module.role.service.RrmRoleMenuService;
import com.rrm.util.BindUserUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色菜单（元素）关联.
 *
 * @author TWL 2024/9/18 17:49
 * @since 1.0
 */
@Service
public class RrmRoleMenuServiceImpl implements RrmRoleMenuService {

    @Autowired
    private RrmMenuMapper rrmMenuMapper;

    @Autowired
    private BindUserUtil bindUserUtil;

    @Autowired
    private RrmRoleMenuMapper rrmRoleMenuMapper;

    @Override
    public ResultVO<List<RrmMenuVO>> getRoleBindMenuByRoleId(String roleId) {
        return ResultVO.success(rrmMenuMapper.getRoleBindMenuByRoleId(roleId));
    }

    @Override
    public ResultVO<String> bindRoleMenu(RrmRoleMenu rrmRoleMenu) {
        bindUserUtil.bindCreateUserInfo(rrmRoleMenu);
        rrmRoleMenuMapper.insert(rrmRoleMenu);
        return ResultVO.success(rrmRoleMenu.getId());
    }

    @Override
    public ResultVO<Void> unbindRoleMenu(String roleId, String menuId) {
        LambdaQueryWrapper<RrmRoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RrmRoleMenu::getRoleId, roleId);
        queryWrapper.eq(RrmRoleMenu::getMenuId, menuId);
        rrmRoleMenuMapper.delete(queryWrapper);
        return ResultVO.success();
    }
}
