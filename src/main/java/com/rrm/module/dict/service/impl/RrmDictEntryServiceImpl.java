package com.rrm.module.dict.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rrm.module.dict.domain.model.RrmDictEntry;
import com.rrm.module.dict.domain.vo.RrmDictEntryVO;
import com.rrm.module.dict.dto.RrmDictEntryDTO;
import com.rrm.module.dict.mapper.RrmDictEntryMapper;
import com.rrm.module.dict.service.RrmDictEntryService;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 字典项.
 *
 * @author TWL 2024/8/12 10:28
 * @since 1.0
 */
@Service
public class RrmDictEntryServiceImpl implements RrmDictEntryService {

    @Autowired
    private RrmDictEntryMapper rrmDictEntryMapper;

    @Override
    public ResultVO<PageResultVO<RrmDictEntryVO>> searchDictEntryPage(RrmDictEntryDTO dto) {
        IPage<RrmDictEntryVO> pageVo = rrmDictEntryMapper.searchDictEntryPage(dto.getPage(RrmDictEntryVO.class), dto);
        return ResultVO.successPage(pageVo);
    }

    @Override
    public ResultVO<RrmDictEntry> getDictEntryById(Long id) {
        return ResultVO.success(rrmDictEntryMapper.selectById(id));
    }

    @Override
    public ResultVO<Long> createDictEntry(RrmDictEntry dictEntry) {
        int count = rrmDictEntryMapper.countByTypeIdAndEntryCode(dictEntry.getTypeId(), dictEntry.getEntryCode());
        if (count > 0) {
            return ResultVO.badRequest("字典代码已经存在！");
        }
        LocalDateTime now = LocalDateTime.now();
        dictEntry.setUpdateTime(now);
        dictEntry.setCreateTime(now);
        rrmDictEntryMapper.insert(dictEntry);
        return ResultVO.success(dictEntry.getId());
    }

    @Override
    public ResultVO<Long> updateDictEntryById(RrmDictEntry dictEntry) {
        dictEntry.setUpdateTime(LocalDateTime.now());
        rrmDictEntryMapper.updateById(dictEntry);
        return ResultVO.success(dictEntry.getId());
    }

    @Override
    public ResultVO<Void> deleteDictEntryById(Long id) {
        rrmDictEntryMapper.deleteById(id);
        return ResultVO.success();
    }
}
