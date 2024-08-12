package com.rrm.module.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rrm.module.dict.domain.model.RrmDictType;
import com.rrm.module.dict.domain.vo.RrmDictTypeVO;
import com.rrm.module.dict.dto.RrmDictTypeDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RrmDictTypeMapper extends BaseMapper<RrmDictType> {

    IPage<RrmDictTypeVO> selectPageVo(IPage<?> page, RrmDictTypeDTO dto);

}