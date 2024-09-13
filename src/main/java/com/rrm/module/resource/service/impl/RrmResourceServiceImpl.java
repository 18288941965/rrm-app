package com.rrm.module.resource.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rrm.module.resource.domain.model.RrmResource;
import com.rrm.module.resource.domain.vo.RrmResourceVO;
import com.rrm.module.resource.dto.RrmResourceDTO;
import com.rrm.module.resource.mapper.RrmResourceMapper;
import com.rrm.module.resource.service.RrmResourceService;
import com.rrm.util.BindUserUtil;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.apache.ibatis.executor.BatchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资源管理.
 *
 * @author TWL 2024/8/30 12:38
 * @since 1.0
 */
@Service
public class RrmResourceServiceImpl implements RrmResourceService {

    @Autowired
    private RrmResourceMapper rrmResourceMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private BindUserUtil bindUserUtil;

    @Override
    public ResultVO<Integer> batchInsertResource(List<RrmResource> list) {
        List<BatchResult> insert = rrmResourceMapper.insert(list);
        return ResultVO.success(insert.size());
    }

    @Override
    public ResultVO<PageResultVO<RrmResourceVO>> searchResourcePage(RrmResourceDTO dto) {
        dto.setItemCode(jwtTokenUtil.getItemCode());
        IPage<RrmResourceVO> pageVo = rrmResourceMapper.searchResourcePage(dto.getPage(RrmResourceVO.class), dto);
        return ResultVO.successPage(pageVo);
    }

    @Override
    public ResultVO<String> updateResourceStatus(RrmResource resource) {
        bindUserUtil.bindUpdateUserInfo(resource);
        return ResultVO.success(resource.getId());
    }
}
