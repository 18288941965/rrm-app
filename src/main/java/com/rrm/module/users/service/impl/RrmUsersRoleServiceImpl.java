package com.rrm.module.users.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rrm.module.role.domain.model.RrmRole;
import com.rrm.module.role.mapper.RrmRoleMapper;
import com.rrm.module.users.domain.model.RrmUsersRole;
import com.rrm.module.users.mapper.RrmUsersRoleMapper;
import com.rrm.module.users.service.RrmUsersRoleService;
import com.rrm.util.BindUserUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色关联表.
 *
 * @author TWL 2024/9/18 17:30
 * @since 1.0
 */
@Service
public class RrmUsersRoleServiceImpl implements RrmUsersRoleService {

    @Autowired
    private RrmRoleMapper rrmRoleMapper;

    @Autowired
    private RrmUsersRoleMapper rrmUsersRoleMapper;

    @Autowired
    private BindUserUtil bindUserUtil;

    @Override
    public ResultVO<List<RrmRole>> getUsersBindRoleByUserId(String usersId) {
        return ResultVO.success(rrmRoleMapper.getUsersBindRoleByUserId(usersId));
    }

    @Override
    public ResultVO<String> bindUsersRole(RrmUsersRole rrmUsersRole) {
        bindUserUtil.bindCreateUserInfo(rrmUsersRole);
        rrmUsersRoleMapper.insert(rrmUsersRole);
        return ResultVO.success(rrmUsersRole.getId());
    }

    @Override
    public ResultVO<Void> unbindUsersRole(String usersId, String roleId) {
        LambdaQueryWrapper<RrmUsersRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RrmUsersRole::getUsersId, usersId);
        queryWrapper.eq(RrmUsersRole::getRoleId, roleId);
        rrmUsersRoleMapper.delete(queryWrapper);
        return ResultVO.success();
    }
}
