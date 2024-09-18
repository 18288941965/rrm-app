package com.rrm.module.menu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rrm.module.menu.domain.model.RrmMenuResource;
import com.rrm.module.menu.dto.RrmMenuResourceDTO;
import com.rrm.module.menu.mapper.RrmMenuResourceMapper;
import com.rrm.module.menu.service.RrmMenuResourceService;
import com.rrm.module.resource.domain.vo.RrmResourceVO;
import com.rrm.module.resource.mapper.RrmResourceMapper;
import com.rrm.util.BindUserUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述.
 *
 * @author TWL 2024/9/18 16:56
 * @since 1.0
 */
@Service
public class RrmMenuResourceImpl implements RrmMenuResourceService {

    @Autowired
    private RrmMenuResourceMapper rrmMenuResourceMapper;

    @Autowired
    private RrmResourceMapper rrmResourceMapper;

    @Autowired
    private BindUserUtil bindUserUtil;

    @Override
    public ResultVO<List<RrmResourceVO>> getMenuBindResourceByMenuId(String menuId) {
        return ResultVO.success(rrmResourceMapper.getMenuBindResource(menuId));
    }

    @Override
    public ResultVO<String> bindMenuResource(RrmMenuResource menuResource) {
        bindUserUtil.bindCreateUserInfo(menuResource);
        rrmMenuResourceMapper.insert(menuResource);
        return ResultVO.success(menuResource.getId());
    }

    @Override
    public ResultVO<Void> unbindMenuResource(RrmMenuResourceDTO dto) {
        LambdaQueryWrapper<RrmMenuResource> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RrmMenuResource::getMenuId, dto.getMenuId());
        queryWrapper.eq(RrmMenuResource::getResourceId, dto.getResourceId());
        rrmMenuResourceMapper.delete(queryWrapper);
        return ResultVO.success();
    }

    @Override
    public ResultVO<Integer> countMenuBindResourceByMenuId(String menuId) {
        return ResultVO.success(rrmResourceMapper.countMenuBindResource(menuId));
    }
}
