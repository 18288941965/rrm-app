package com.rrm.module.role.service.impl;

import com.rrm.cache.RrmUserCache;
import com.rrm.module.role.domain.model.RrmRole;
import com.rrm.module.role.mapper.RrmRoleMapper;
import com.rrm.module.role.service.RrmRoleService;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 类描述.
 *
 * @author TWL 2024/8/30 12:35
 * @since 1.0
 */
@Service
public class RrmRoleServiceImpl implements RrmRoleService {

    @Autowired
    private RrmRoleMapper rrmRoleMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public ResultVO<String> createRole(RrmRole rrmRole) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        rrmRole.setCreatedAt(LocalDateTime.now());
        rrmRole.setCreatedBy(userInfo.getId());
        rrmRole.setItemCode(userInfo.getItemCode());
        rrmRoleMapper.insert(rrmRole);
        return ResultVO.success(rrmRole.getId());
    }

    @Override
    public ResultVO<String> deleteRoleById(String id) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        RrmRole rrmRole = new RrmRole();
        rrmRole.setId(id);
        rrmRole.setStatus((byte)0);
        rrmRole.setUpdatedBy(userInfo.getId());
        rrmRole.setUpdatedAt(LocalDateTime.now());
        rrmRoleMapper.updateById(rrmRole);
        // TODO 删除其他关联信息
        return ResultVO.success(id);
    }

    @Override
    public ResultVO<String> updateUserById(RrmRole rrmRole) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        rrmRole.setUpdatedBy(userInfo.getId());
        rrmRole.setUpdatedAt(LocalDateTime.now());
        rrmRoleMapper.updateById(rrmRole);
        return ResultVO.success(rrmRole.getId());
    }

    @Override
    public ResultVO<RrmRole> getRoleById(String id) {
        return null;
    }
}
