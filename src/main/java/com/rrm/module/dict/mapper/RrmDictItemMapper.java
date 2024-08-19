package com.rrm.module.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rrm.module.dict.domain.model.RrmDictItem;
import com.rrm.module.dict.domain.vo.RrmDictItemVO;
import com.rrm.module.dict.domain.vo.RrmDictTypeVO;
import com.rrm.module.dict.dto.RrmDictItemDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RrmDictItemMapper extends BaseMapper<RrmDictItem> {

    IPage<RrmDictItemVO> searchDictItemPage(Page<RrmDictTypeVO> page, @Param("dto") RrmDictItemDTO dto);

    int countByTypeCodeAndItemCode(String typeCode, String itemCode);
}