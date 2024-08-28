package com.rrm.module.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrm.module.menu.domain.model.RrmMenu;
import com.rrm.module.menu.domain.vo.RrmMenuVO;
import com.rrm.module.menu.dto.RrmMenuMoveDTO;
import com.rrm.vo.ResultVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RrmMenuMapper extends BaseMapper<RrmMenu> {

    List<RrmMenuVO> selectMenuByItemCodeOrId(String itemCode, String id);

    void batchUpdateMenuParent(@Param("dto") RrmMenuMoveDTO menuMoveDTO);
}