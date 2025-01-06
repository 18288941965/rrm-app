package com.rrm.module.role.service.impl;

import com.rrm.module.role.domain.model.RrmRole;
import com.rrm.module.role.domain.vo.RrmRoleVO;
import com.rrm.module.role.mapper.RrmRoleMapper;
import com.rrm.module.role.mapper.RrmRoleMenuMapper;
import com.rrm.module.role.service.RrmRoleService;
import com.rrm.module.users.mapper.RrmUsersRoleMapper;
import com.rrm.util.BindUserUtil;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.ResultVO;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private RrmUsersRoleMapper rrmUsersRoleMapper;

    @Autowired
    private RrmRoleMenuMapper rrmRoleMenuMapper;

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
    @Transactional
    public ResultVO<String> deleteRoleById(String id) {
        // 删除角色信息
        rrmRoleMapper.deleteById(id);
        // 根据角色id删除 角色 菜单|控件 关联信息
        rrmRoleMenuMapper.deleteByRoleId(id);
        // 根据角色ID删除 用户 机构 角色关联信息
        rrmUsersRoleMapper.deleteByRoleId(id);
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

    public static List<RrmRoleVO> buildRoleTree(List<RrmRoleVO> roleList) {
        Map<String, RrmRoleVO> roleMap = new HashMap<>();
        List<RrmRoleVO> rootRoles = new ArrayList<>();

        // Step 1: 将所有角色存入 map，key 为菜单的 id
        for (RrmRoleVO role : roleList) {
            roleMap.put(role.getId(), role);
        }

        // Step 2: 构建树结构
        for (RrmRoleVO role : roleList) {
            if (Strings.isBlank(role.getParentId())) {
                // 如果没有 parentId，则为根角色
                rootRoles.add(role);
            } else {
                // 否则，将其添加到对应的父节点的 children 列表中
                RrmRoleVO parentRole = roleMap.get(role.getParentId());
                if (parentRole != null) {
                    parentRole.getChildren().add(role);
                }
            }
        }
        return rootRoles;
    }

    @Override
    public ResultVO<List<RrmRoleVO>> getRoleTreeByItemCode() {
        String itemCode = jwtTokenUtil.getItemCode();
        List<RrmRoleVO> dataList = rrmRoleMapper.selectRoleByItemCodeOrId(itemCode, null);
        List<RrmRoleVO> rrmRoleVOS = buildRoleTree(dataList);
        return ResultVO.success(rrmRoleVOS);
    }
}
