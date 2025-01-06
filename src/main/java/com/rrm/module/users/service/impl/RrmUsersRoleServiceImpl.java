package com.rrm.module.users.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rrm.cache.RrmUserCache;
import com.rrm.module.role.domain.model.RrmRole;
import com.rrm.module.role.mapper.RrmRoleMapper;
import com.rrm.module.users.domain.model.RrmUsersRole;
import com.rrm.module.users.dto.RrmUsersRoleDTO;
import com.rrm.module.users.mapper.RrmUsersRoleMapper;
import com.rrm.module.users.service.RrmUsersRoleService;
import com.rrm.util.BindUserUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public ResultVO<List<RrmRole>> getUsersBindRole(String usersId, String orgId) {
        return ResultVO.success(rrmRoleMapper.getUsersBindRole(usersId, orgId));
    }

    @Override
    @Transactional
    public ResultVO<Void> bindUsersRole(RrmUsersRoleDTO rrmUsersRoleDTO) {
        unbindUsersRole(rrmUsersRoleDTO.getUsersId(), rrmUsersRoleDTO.getOrgId());

        List<RrmUsersRole> usersRoleList = new ArrayList<>();
        RrmUserCache rrmUserCache = bindUserUtil.getRrmUserCache();
        LocalDateTime now = LocalDateTime.now();
        rrmUsersRoleDTO.getRoleIdList().forEach(roleId -> {
            RrmUsersRole bean = new RrmUsersRole();
            bean.setId(DigestUtil.md5Hex(rrmUsersRoleDTO.getUsersId() + rrmUsersRoleDTO.getOrgId() + roleId));
            bean.setCreatedBy(rrmUserCache.getId());
            bean.setCreatedAt(now);
            bean.setUsersId(rrmUsersRoleDTO.getUsersId());
            bean.setOrgId(rrmUsersRoleDTO.getOrgId());
            bean.setRoleId(roleId);
            bean.setItemCode(rrmUserCache.getItemCode());
            usersRoleList.add(bean);
        });
        if (!usersRoleList.isEmpty()) {
            rrmUsersRoleMapper.batchInsert(usersRoleList);
        }
        return ResultVO.success();
    }

    public void unbindUsersRole(String usersId, String orgId) {
        LambdaQueryWrapper<RrmUsersRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RrmUsersRole::getUsersId, usersId);
        queryWrapper.eq(RrmUsersRole::getOrgId, orgId);
        rrmUsersRoleMapper.delete(queryWrapper);
    }
}
