package com.rrm.module.dict.service;

import com.rrm.module.dict.domain.model.RrmDictEntry;
import com.rrm.module.dict.domain.vo.RrmDictEntryVO;
import com.rrm.module.dict.dto.RrmDictEntryDTO;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 字典项.
 *
 * @author TWL 2024/8/12 10:28
 * @since 1.0
 */
public interface RrmDictEntryService {

    ResultVO<PageResultVO<RrmDictEntryVO>> searchDictEntryPage(@RequestBody RrmDictEntryDTO dto);

    ResultVO<RrmDictEntry> getDictEntryById(Long id);

    ResultVO<Long> createDictEntry(RrmDictEntry dictEntry);

    ResultVO<Long> updateDictEntryById(RrmDictEntry dictEntry);

    ResultVO<Void> deleteDictEntryById(Long id);
}
