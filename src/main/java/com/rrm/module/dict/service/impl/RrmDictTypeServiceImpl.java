package com.rrm.module.dict.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rrm.module.dict.domain.model.RrmDictType;
import com.rrm.module.dict.domain.vo.RrmDictTypeVO;
import com.rrm.module.dict.dto.RrmDictTypeDTO;
import com.rrm.module.dict.mapper.RrmDictTypeMapper;
import com.rrm.module.dict.service.RrmDictTypeService;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

/**
 * 字典类型.
 *
 * @author TWL 2024/8/12 10:29
 * @since 1.0
 */
@Service
public class RrmDictTypeServiceImpl implements RrmDictTypeService {

    @Autowired
    private RrmDictTypeMapper rrmDictTypeMapper;


    @Override
    public ResultVO<PageResultVO<RrmDictTypeVO>> searchWithPagination(@RequestBody RrmDictTypeDTO dto) {
        IPage<RrmDictTypeVO> pageVo = rrmDictTypeMapper.selectPageVo(dto.getPage(RrmDictTypeVO.class), dto);
        return ResultVO.successPage(pageVo);
    }

    @Override
    public RrmDictType findById(Long id) {
        return rrmDictTypeMapper.selectById(id);
    }

    @Override
    public void save(RrmDictType dictType) {
        LocalDateTime now = LocalDateTime.now();
        dictType.setCreateTime(now);
        dictType.setUpdateTime(now);
        rrmDictTypeMapper.insert(dictType);
    }

    @Override
    public void updateDictType(RrmDictType rrmDictType) {
        rrmDictType.setUpdateTime(LocalDateTime.now());
        rrmDictTypeMapper.updateById(rrmDictType);
    }

    @Override
    public void deleteById(Long id) {
        rrmDictTypeMapper.deleteById(id);
    }
}
