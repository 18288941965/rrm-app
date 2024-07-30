package com.rrm.module.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rrm.module.user.domain.model.RrmUser;
import com.rrm.module.user.mapper.RrmUserMapper;
import com.rrm.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统用户管理类.
 *
 * @author TWL 2024/7/30 8:56
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public RrmUserMapper rrmUserMapper;

    @Override
    public RrmUser getUserByName(String username) {
        LambdaQueryWrapper<RrmUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RrmUser::getUsername, username);
        List<RrmUser> rrmUsers = rrmUserMapper.selectList(queryWrapper);
        return !rrmUsers.isEmpty() ? rrmUsers.get(0) : null;
    }
}
