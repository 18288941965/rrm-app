package com.rrm.module.role.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rrm.module.role.domain.model.RrmRole;
import com.rrm.module.role.dto.RrmRoleDTO;
import com.rrm.module.role.mapper.RrmRoleMapper;
import com.rrm.module.role.service.RrmRoleService;
import com.rrm.util.BindUserUtil;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.PageResultVO;
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

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private BindUserUtil bindUserUtil;

    @Override
    public ResultVO<String> createRole(RrmRole rrmRole) {
        bindUserUtil.bindCreateUserInfo(rrmRole);
        rrmRoleMapper.insert(rrmRole);
        return ResultVO.success(rrmRole.getId());
    }

    @Override
    public ResultVO<String> deleteRoleById(String id) {
        rrmRoleMapper.deleteById(id);
        // TODO 删除其他关联信息
        return ResultVO.success(id);
    }

    @Override
    public ResultVO<String> updateRoleById(RrmRole rrmRole) {
        bindUserUtil.bindUpdateUserInfo(rrmRole);
        rrmRoleMapper.updateById(rrmRole);
        return ResultVO.success(rrmRole.getId());
    }

    @Override
    public ResultVO<RrmRole> getRoleById(String id) {
        return ResultVO.success(rrmRoleMapper.selectById(id));
    }

    @Override
    public ResultVO<PageResultVO<RrmRole>> searchRolePage(RrmRoleDTO dto) {
        dto.setItemCode(jwtTokenUtil.getItemCode());
        IPage<RrmRole> pageVo = rrmRoleMapper.searchRolePage(dto.getPage(RrmRole.class), dto);
        return ResultVO.successPage(pageVo);
    }
}
