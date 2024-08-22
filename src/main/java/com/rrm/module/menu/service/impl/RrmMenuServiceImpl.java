package com.rrm.module.menu.service.impl;

import com.rrm.cache.RrmUserCache;
import com.rrm.module.menu.domain.model.RrmMenu;
import com.rrm.module.menu.mapper.RrmMenuMapper;
import com.rrm.module.menu.service.RrmMenuService;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    @Override
    public ResultVO<RrmMenu> getMenuById(String id) {
        return ResultVO.success(rrmMenuMapper.selectById(id));
    }

    @Override
    public ResultVO<String> createMenu(RrmMenu menu) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        menu.setCreatedAt(LocalDateTime.now());
        menu.setCreatedBy(userInfo.getId());
        menu.setItemCode(userInfo.getItemCode());
        rrmMenuMapper.insert(menu);
        return ResultVO.success(menu.getId());
    }

    @Override
    public ResultVO<String> updateMenuById(RrmMenu menu) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        menu.setUpdatedAt(LocalDateTime.now());
        menu.setUpdatedBy(userInfo.getId());
        rrmMenuMapper.updateById(menu);
        return ResultVO.success(menu.getId());
    }

    @Override
    public ResultVO<Void> deleteMenuById(String id) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        RrmMenu menu = new RrmMenu();
        menu.setId(id);
        menu.setStatus((byte) 0);
        menu.setUpdatedAt(LocalDateTime.now());
        menu.setUpdatedBy(userInfo.getId());
        rrmMenuMapper.updateById(menu);
        // TODO 删除关联的资源，删除角色绑定的菜单等
        return ResultVO.success();
    }
}
