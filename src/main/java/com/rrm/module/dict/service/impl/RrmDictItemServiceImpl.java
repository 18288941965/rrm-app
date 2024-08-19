package com.rrm.module.dict.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rrm.module.dict.domain.model.RrmDictItem;
import com.rrm.module.dict.domain.vo.RrmDictItemVO;
import com.rrm.module.dict.domain.vo.RrmDictTypeVO;
import com.rrm.module.dict.dto.RrmDictItemDTO;
import com.rrm.module.dict.mapper.RrmDictItemMapper;
import com.rrm.module.dict.service.RrmDictItemService;
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
public class RrmDictItemServiceImpl implements RrmDictItemService {

    @Autowired
    private RrmDictItemMapper rrmDictItemMapper;

    @Override
    public ResultVO<PageResultVO<RrmDictItemVO>> searchDictItemPage(RrmDictItemDTO dto) {
        IPage<RrmDictItemVO> pageVo = rrmDictItemMapper.searchDictItemPage(dto.getPage(RrmDictTypeVO.class), dto);
        return ResultVO.successPage(pageVo);
    }

    @Override
    public ResultVO<RrmDictItem> getDictItemById(Long id) {
        return ResultVO.success(rrmDictItemMapper.selectById(id));
    }

    @Override
    public ResultVO<Long> createDictItem(RrmDictItem dictItem) {
        int count = rrmDictItemMapper.countByTypeCodeAndItemCode(dictItem.getTypeCode(), dictItem.getItemCode());
        if (count > 0) {
            return ResultVO.badRequest("字典代码已经存在！");
        }
        LocalDateTime now = LocalDateTime.now();
        dictItem.setUpdateTime(now);
        dictItem.setCreateTime(now);
        rrmDictItemMapper.insert(dictItem);
        return ResultVO.success(dictItem.getId());
    }

    @Override
    public ResultVO<Long> updateDictItemById(RrmDictItem dictItem) {
        dictItem.setUpdateTime(LocalDateTime.now());
        rrmDictItemMapper.updateById(dictItem);
        return ResultVO.success(dictItem.getId());
    }

    @Override
    public ResultVO<Void> deleteDictItemById(Long id) {
        rrmDictItemMapper.deleteById(id);
        return ResultVO.success();
    }
}
