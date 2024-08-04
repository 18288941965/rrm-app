package com.rrm.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrm.module.user.domain.model.RrmUser;
import com.rrm.module.user.domain.model.RrmUserItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RrmUserItemMapper extends BaseMapper<RrmUserItem> {

    int deleteByItemCode(int id);
}