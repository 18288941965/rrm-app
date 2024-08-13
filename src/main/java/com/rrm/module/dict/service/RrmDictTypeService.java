package com.rrm.module.dict.service;

import com.rrm.module.dict.domain.model.RrmDictType;
import com.rrm.module.dict.domain.vo.RrmDictTypeVO;
import com.rrm.module.dict.dto.RrmDictTypeDTO;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 字典类型.
 *
 * @author TWL 2024/8/12 10:28
 * @since 1.0
 */
public interface RrmDictTypeService {

    ResultVO<PageResultVO<RrmDictTypeVO>> searchDictTypePage(@RequestBody RrmDictTypeDTO dto);

    ResultVO<RrmDictType> getDictTypeById(Long id);

    ResultVO<Long> createDictType(RrmDictType dictType);

    ResultVO<Long> updateDictTypeById(RrmDictType rrmDictType);

    ResultVO<Void> deleteDictTypeById(Long id);
}
