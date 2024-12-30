package com.rrm.module.dict.service;

import com.rrm.module.dict.domain.model.RrmDictEntry;
import com.rrm.module.dict.domain.vo.RrmDictEntryVO;
import com.rrm.module.dict.domain.vo.RrmDictVO;
import com.rrm.module.dict.dto.RrmDictEntryDTO;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 字典项.
 *
 * @author TWL 2024/8/12 10:28
 * @since 1.0
 */
public interface RrmDictEntryService {

    ResultVO<PageResultVO<RrmDictEntryVO>> searchDictEntryPage(@RequestBody RrmDictEntryDTO dto);

    ResultVO<RrmDictEntry> getDictEntryById(String id);

    ResultVO<String> createDictEntry(RrmDictEntry dictEntry);

    ResultVO<String> updateDictEntryById(RrmDictEntry dictEntry);

    ResultVO<Void> deleteDictEntryById(String id);

    ResultVO<Void> updateEntryStatus(Byte status, String id);

    ResultVO<List<RrmDictEntry>> getDictEntryByTypeCode(String typeCode);

    ResultVO<Void> updateDictEntrySort(List<RrmDictEntry> entryList);

    ResultVO<List<RrmDictVO>> selectDictEntryByTypeCode(String typeCode);
}
