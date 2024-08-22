package com.rrm.module.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rrm.module.dict.domain.model.RrmDictEntry;
import com.rrm.module.dict.domain.vo.RrmDictEntryVO;
import com.rrm.module.dict.domain.vo.RrmDictVO;
import com.rrm.module.dict.dto.RrmDictEntryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RrmDictEntryMapper extends BaseMapper<RrmDictEntry> {

    IPage<RrmDictEntryVO> searchDictEntryPage(Page<RrmDictEntryVO> page, @Param("dto") RrmDictEntryDTO dto);

    int countByTypeIdAndEntryCode(Integer typeId, String entryCode);

    void updateEntryStatus(Byte status, Long id);

    List<RrmDictVO> getDictEntryByTypeCode(String typeCode, String itemCode);
}