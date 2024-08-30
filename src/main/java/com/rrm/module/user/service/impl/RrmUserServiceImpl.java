package com.rrm.module.user.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rrm.cache.RrmUserCache;
import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.module.item.mapper.RrmItemMapper;
import com.rrm.module.user.domain.model.RrmUser;
import com.rrm.module.user.domain.model.RrmUserItem;
import com.rrm.module.user.domain.vo.RrmUserVO;
import com.rrm.module.user.mapper.RrmUserItemMapper;
import com.rrm.module.user.mapper.RrmUserMapper;
import com.rrm.module.user.service.RrmUserService;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 系统用户管理类.
 *
 * @author TWL 2024/7/30 8:56
 * @since 1.0
 */
@Service
public class RrmUserServiceImpl implements RrmUserService {

    @Autowired
    public RrmUserMapper rrmUserMapper;

    @Autowired
    private RrmUserItemMapper rrmUserItemMapper;

    @Autowired
    private RrmItemMapper rrmItemMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public RrmUser getUserByName(String username) {
        LambdaQueryWrapper<RrmUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RrmUser::getUsername, username);
        List<RrmUser> rrmUsers = rrmUserMapper.selectList(queryWrapper);
        return !rrmUsers.isEmpty() ? rrmUsers.get(0) : null;
    }

    @Override
    public ResultVO<String> createUser(RrmUser rrmUser) {
        rrmUser.setPassword(SecureUtil.md5(rrmUser.getPassword()));
        rrmUserMapper.insert(rrmUser);
        return ResultVO.success();
    }

    @Override
    public ResultVO<String> deleteUserAndAssociations(Integer id) {
        rrmUserMapper.deleteById(id);
        rrmUserItemMapper.deleteByUserId(id);
        return ResultVO.success();
    }

    @Override
    public ResultVO<String> updateUserPassword( RrmUserVO rrmUserVO) {
        // 验证密码是否正确
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        RrmUser user = getUserByName(userInfo.getUsername());
        String s = SecureUtil.md5(rrmUserVO.getPassword());
        if (!s.equals(user.getPassword())) {
            return ResultVO.badRequest("旧密码不正确");
        }

        String newPassword = SecureUtil.md5(rrmUserVO.getNewPassword());
        rrmUserMapper.updatePassword(userInfo.getId(), newPassword);
        return ResultVO.success();
    }

    @Override
    public ResultVO<String> updateUserDescription(RrmUser rrmUser) {
        rrmUserMapper.updateUserDescription(rrmUser.getId(), rrmUser.getDescription());
        return ResultVO.success();
    }


    @Override
    public ResultVO<List<RrmUserVO>> getAllUser() {

        // 所有用户
        List<RrmUserVO> rrmUsers = rrmUserMapper.getAllUser();
        // 所有用户关联项目
        List<RrmUserItem> rrmUserItems = rrmUserItemMapper.selectList(null);
        // 所有项目
        List<RrmItem> rrmItems = rrmItemMapper.selectList(null);

        rrmUsers.forEach(user -> {
            List<Integer> correlationItemId = rrmUserItems
                    .stream()
                    .filter(rrmUserItem -> Objects.equals(user.getId(), rrmUserItem.getUserId()))
                    .map(RrmUserItem::getItemId)
                    .collect(Collectors.toList());
            List<RrmItem> correlationItem = rrmItems
                    .stream()
                    .filter(item -> correlationItemId.contains(item.getId()))
                    .collect(Collectors.toList());
            user.setItemList(correlationItem);
        });

        return ResultVO.success(rrmUsers);
    }

    @Override
    public ResultVO<RrmUser> getUserById(Integer id) {
        return ResultVO.success(rrmUserMapper.selectById(id));
    }

    @Override
    public ResultVO<List<RrmUserVO>> getAllUserBase() {
        return ResultVO.success(rrmUserMapper.getAllUser());
    }
}
