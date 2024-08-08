package com.rrm.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrm.module.user.domain.model.RrmUserItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RrmUserItemMapper extends BaseMapper<RrmUserItem> {

    int deleteByItemId(int itemId);

    int deleteByUserId(int userId);

    List<Integer> getCorrelationUserId(Integer itemId);

    int deleteUserItem(Integer userId, Integer itemId);
}