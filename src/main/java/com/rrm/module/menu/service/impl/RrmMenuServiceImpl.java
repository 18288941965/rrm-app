package com.rrm.module.menu.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rrm.cache.RrmUserCache;
import com.rrm.module.menu.domain.model.RrmMenu;
import com.rrm.module.menu.domain.vo.RrmMenuVO;
import com.rrm.module.menu.dto.RrmMenuMoveDTO;
import com.rrm.module.menu.mapper.RrmMenuMapper;
import com.rrm.module.menu.service.RrmMenuService;
import com.rrm.util.BindUserUtil;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.ResultVO;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理.
 *
 * @author TWL 2024/8/8 15:57
 * @since 1.0
 */
@Service
public class RrmMenuServiceImpl implements RrmMenuService {

    @Autowired
    private RrmMenuMapper rrmMenuMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private BindUserUtil bindUserUtil;

    @Override
    public ResultVO<RrmMenuVO> getMenuById(String id) {
        List<RrmMenuVO> dataList = rrmMenuMapper.selectMenuByItemCodeOrId(null, id);
        return ResultVO.success(dataList.get(0));
    }

    @Override
    public ResultVO<String> createMenu(RrmMenu menu) {
        bindUserUtil.bindCreateUserInfo(menu);
        rrmMenuMapper.insert(menu);
        return ResultVO.success(menu.getId());
    }

    @Override
    public ResultVO<String> updateMenuById(RrmMenu menu) {
        bindUserUtil.bindUpdateUserInfo(menu);
        rrmMenuMapper.updateById(menu);
        return ResultVO.success(menu.getId());
    }

    @Override
    public ResultVO<Void> deleteMenuById(String ids) {
        rrmMenuMapper.deleteById(ids);
        // TODO 删除关联的资源，删除角色绑定的菜单等
        return ResultVO.success();
    }

    public static List<RrmMenuVO> buildMenuTree(List<RrmMenuVO> menuList) {
        Map<String, RrmMenuVO> menuMap = new HashMap<>();
        List<RrmMenuVO> rootMenus = new ArrayList<>();

        // Step 1: 将所有菜单存入 map，key 为菜单的 id
        for (RrmMenuVO menu : menuList) {
            menuMap.put(menu.getId(), menu);
        }

        // Step 2: 构建树结构
        for (RrmMenuVO menu : menuList) {
            if (Strings.isBlank(menu.getParentId())) {
                // 如果没有 parentId，则为根菜单
                rootMenus.add(menu);
            } else {
                // 否则，将其添加到对应的父节点的 children 列表中
                RrmMenuVO parentMenu = menuMap.get(menu.getParentId());
                if (parentMenu != null) {
                    parentMenu.getChildren().add(menu);
                }
            }
        }
        return rootMenus;
    }

    @Override
    public ResultVO<List<RrmMenuVO>> getMenuTreeByItemCode() {
        String itemCode = jwtTokenUtil.getItemCode();
        List<RrmMenuVO> dataList = rrmMenuMapper.selectMenuByItemCodeOrId(itemCode, null);
        List<RrmMenuVO> rrmMenuVOS = buildMenuTree(dataList);
        return ResultVO.success(rrmMenuVOS);
    }

    @Override
    public ResultVO<Void> batchUpdateMenuParent(RrmMenuMoveDTO menuMoveDTO) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        menuMoveDTO.setUpdatedBy(userInfo.getId());
        menuMoveDTO.setUpdatedAt(LocalDateTime.now());
        if (StrUtil.isBlank(menuMoveDTO.getParentId())) {
            menuMoveDTO.setParentId(null);
        }
        rrmMenuMapper.batchUpdateMenuParent(menuMoveDTO);
        return ResultVO.success();
    }

    @Override
    public ResultVO<List<RrmMenu>> getMenuByParentId(String parentId) {
        LambdaQueryWrapper<RrmMenu> queryWrapper = new LambdaQueryWrapper<>();
        if ("null".equals(parentId)) {
            queryWrapper.isNull(true, RrmMenu::getParentId);
        } else {
            queryWrapper.eq(RrmMenu::getParentId, parentId);
        }
        queryWrapper.eq(RrmMenu::getStatus, (byte)1);
        queryWrapper.orderBy(true, true, RrmMenu::getSortOrder);
        return ResultVO.success(rrmMenuMapper.selectList(queryWrapper));
    }

    @Override
    public ResultVO<Void> updateMenuSort(List<RrmMenu> menuList) {
        rrmMenuMapper.updateById(menuList);
        return ResultVO.success();
    }

    @Override
    public ResultVO<Long> countByItemCode() {
        LambdaQueryWrapper<RrmMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RrmMenu::getItemCode, jwtTokenUtil.getItemCode());
        queryWrapper.eq(RrmMenu::getStatus, (byte)1);
        Long menuCount = rrmMenuMapper.selectCount(queryWrapper);
        return ResultVO.success(menuCount);
    }
}
