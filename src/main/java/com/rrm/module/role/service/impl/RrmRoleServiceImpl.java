package com.rrm.module.role.service.impl;

import com.rrm.module.role.domain.model.RrmRole;
import com.rrm.module.role.mapper.RrmRoleMapper;
import com.rrm.module.role.service.RrmRoleService;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public ResultVO<String> createRole(RrmRole rrmRole) {
        return null;
    }

    @Override
    public ResultVO<String> deleteRoleById(String id) {
        return null;
    }

    @Override
    public ResultVO<String> updateUserById(RrmRole rrmRole) {
        return null;
    }

    @Override
    public ResultVO<RrmRole> getRoleById(String id) {
        return null;
    }
}
