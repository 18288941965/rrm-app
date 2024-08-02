package com.rrm.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrm.module.user.domain.model.RrmUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RrmUserMapper extends BaseMapper<RrmUser> {

    void updatePassword(Integer id, String password);
}