package com.rrm.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrm.module.user.domain.model.RrmUserItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RrmUserItemMapper extends BaseMapper<RrmUserItem> {

    int deleteByItemCode(String itemCode);

    int deleteByUserId(int userId);

    List<String> getCorrelationUserId(String itemCode);

    int deleteUserItem(Integer userId, String itemCode);
}