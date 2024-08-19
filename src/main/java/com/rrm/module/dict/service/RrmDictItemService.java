package com.rrm.module.dict.service;

import com.rrm.module.dict.domain.model.RrmDictItem;
import com.rrm.module.dict.domain.vo.RrmDictItemVO;
import com.rrm.module.dict.dto.RrmDictItemDTO;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 字典项.
 *
 * @author TWL 2024/8/12 10:28
 * @since 1.0
 */
public interface RrmDictItemService {

    ResultVO<PageResultVO<RrmDictItemVO>> searchDictItemPage(@RequestBody RrmDictItemDTO dto);

    ResultVO<RrmDictItem> getDictItemById(Long id);

    ResultVO<Long> createDictItem(RrmDictItem dictItem);

    ResultVO<Long> updateDictItemById(RrmDictItem dictItem);

    ResultVO<Void> deleteDictItemById(Long id);
}
