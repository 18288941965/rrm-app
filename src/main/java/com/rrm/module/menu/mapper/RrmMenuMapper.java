package com.rrm.module.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrm.module.menu.domain.model.RrmMenu;
import com.rrm.module.menu.domain.vo.RrmMenuVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RrmMenuMapper extends BaseMapper<RrmMenu> {

    List<RrmMenuVO> selectMenuByItemCode(String itemCode);
}