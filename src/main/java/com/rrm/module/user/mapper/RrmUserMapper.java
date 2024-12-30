package com.rrm.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrm.module.user.domain.model.RrmUser;
import com.rrm.module.user.domain.vo.RrmUserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RrmUserMapper extends BaseMapper<RrmUser> {

    void updatePassword(String id, String password);

    void updateUserDescription(String id, String description);

    List<RrmUserVO> getAllUser();

    List<RrmUser> getAllUser2();
}