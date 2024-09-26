package com.rrm.module.role.service.impl;

import com.rrm.module.menu.domain.model.RrmMenuElement;
import com.rrm.module.menu.service.RrmMenuElementService;
import com.rrm.module.role.domain.model.RrmRoleMenu;
import com.rrm.module.role.mapper.RrmRoleMenuMapper;
import com.rrm.module.role.service.RrmRoleMenuService;
import com.rrm.util.BindUserUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private BindUserUtil bindUserUtil;

    @Autowired
    private RrmRoleMenuMapper rrmRoleMenuMapper;

    @Autowired
    private RrmMenuElementService rrmMenuElementService;

    @Override
    public ResultVO<List<RrmRoleMenu>> getRoleBindMenuByRoleId(String roleId) {
        return ResultVO.success(rrmRoleMenuMapper.getBindMenuIds(roleId));
    }

    @Override
    @Transactional
    public ResultVO<String> bindRoleMenu(RrmRoleMenu rrmRoleMenu) {
        bindUserUtil.bindCreateUserInfo(rrmRoleMenu);
        String[] menuIds = rrmRoleMenu.getMenuId().split(",");
        for (String menuId : menuIds) {
            RrmRoleMenu bean = new RrmRoleMenu();
            bean.setRoleId(rrmRoleMenu.getRoleId());
            bean.setMenuId(menuId);
            bean.setType(rrmRoleMenu.getType());
            bean.setCreatedBy(rrmRoleMenu.getCreatedBy());
            bean.setCreatedAt(rrmRoleMenu.getCreatedAt());
            bean.setItemCode(rrmRoleMenu.getItemCode());
            rrmRoleMenuMapper.insert(bean);
        }
        return ResultVO.success("");
    }

    @Override
    @Transactional
    public ResultVO<List<String>> unbindRoleMenu(String roleId, String menuId, String type) {
        String[] menuIds = menuId.split(",");
        List<String> removeElementIds = new ArrayList<>();
        for (String id : menuIds) {

            // 取消绑定菜单下的控件：严格遵循绑定上下级关系
            String flag = "01";
            if (flag.equals(type)) {
                List<RrmMenuElement> menuElementList = rrmMenuElementService.getMenuElementByMenuId(id).getData();
                for (RrmMenuElement rrmMenuElement : menuElementList) {
                    int changeRow = rrmRoleMenuMapper.deleteByRoleIdAndMenuId(roleId, rrmMenuElement.getId());
                    if (changeRow > 0) {
                        removeElementIds.add(rrmMenuElement.getId());
                    }
                }
            }

            rrmRoleMenuMapper.deleteByRoleIdAndMenuId(roleId, id);
        }
        return ResultVO.success(removeElementIds);
    }
}
