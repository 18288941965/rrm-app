package com.rrm.module.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rrm.module.dict.domain.model.RrmDictType;
import com.rrm.module.dict.domain.vo.RrmDictTypeVO;
import com.rrm.module.dict.dto.RrmDictTypeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RrmDictTypeMapper extends BaseMapper<RrmDictType> {

    IPage<RrmDictTypeVO> selectDictTypePage(IPage<?> page, @Param("dto") RrmDictTypeDTO dto);

    RrmDictType selectByTypeCode(String typeCode);
}