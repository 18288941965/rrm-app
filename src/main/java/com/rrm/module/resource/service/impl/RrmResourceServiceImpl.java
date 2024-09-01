package com.rrm.module.resource.service.impl;

import com.rrm.module.resource.domain.model.RrmResource;
import com.rrm.module.resource.mapper.RrmResourceMapper;
import com.rrm.module.resource.service.RrmResourceService;
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

    @Override
    public ResultVO<Integer> batchInsertResource(List<RrmResource> list) {
        List<BatchResult> insert = rrmResourceMapper.insert(list);
        return ResultVO.success(insert.size());
    }
}
