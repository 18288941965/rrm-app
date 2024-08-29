package com.rrm.module.menu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rrm.cache.RrmUserCache;
import com.rrm.module.menu.domain.model.RrmMenuElement;
import com.rrm.module.menu.mapper.RrmMenuElementMapper;
import com.rrm.module.menu.service.RrmMenuElementService;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 菜单元素管理.
 *
 * @author TWL 2024/8/8 15:57
 * @since 1.0
 */
@Service
public class RrmMenuElementServiceImpl implements RrmMenuElementService {

    @Autowired
    private RrmMenuElementMapper rrmMenuElementMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    public ResultVO<List<RrmMenuElement>> getMenuElementByMenuId(String menuId) {
        LambdaQueryWrapper<RrmMenuElement> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RrmMenuElement::getMenuId, menuId);
        List<RrmMenuElement> rrmMenuElements = rrmMenuElementMapper.selectList(queryWrapper);
        return ResultVO.success(rrmMenuElements);
    }

    @Override
    public ResultVO<RrmMenuElement> getMenuElementById(String id) {
        return ResultVO.success(rrmMenuElementMapper.selectById(id));
    }

    @Override
    public ResultVO<String> createMenuElement(RrmMenuElement menuElement) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        menuElement.setCreatedAt(LocalDateTime.now());
        menuElement.setCreatedBy(userInfo.getId());
        rrmMenuElementMapper.insert(menuElement);
        return ResultVO.success(menuElement.getMenuId());
    }

    @Override
    public ResultVO<String> updateMenuElementById(RrmMenuElement menuElement) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        menuElement.setUpdatedAt(LocalDateTime.now());
        menuElement.setUpdatedBy(userInfo.getId());
        rrmMenuElementMapper.updateById(menuElement);
        return ResultVO.success(menuElement.getMenuId());
    }

    @Override
    public ResultVO<Void> deleteMenuElementById(String id) {
        RrmMenuElement menuElement = new RrmMenuElement();
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        menuElement.setUpdatedAt(LocalDateTime.now());
        menuElement.setUpdatedBy(userInfo.getId());
        menuElement.setStatus((byte)0);
        rrmMenuElementMapper.updateById(menuElement);
        return ResultVO.success();
    }
}
