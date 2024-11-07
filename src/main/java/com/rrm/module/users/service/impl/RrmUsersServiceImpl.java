package com.rrm.module.users.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rrm.module.users.domain.model.RrmUsers;
import com.rrm.module.users.domain.vo.RrmUsersVO;
import com.rrm.module.users.dto.RrmUsersDTO;
import com.rrm.module.users.mapper.RrmUsersMapper;
import com.rrm.module.users.service.RrmUsersService;
import com.rrm.util.BindUserUtil;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 用户管理.
 *
 * @author TWL 2024/9/5 15:39
 * @since 1.0
 */
@Service
public class RrmUsersServiceImpl implements RrmUsersService {

    @Autowired
    private RrmUsersMapper rrmUsersMapper;

    @Autowired
    private BindUserUtil bindUserUtil;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public ResultVO<String> createUsers(RrmUsers rrmUsers) {
        String itemCode = jwtTokenUtil.getItemCode();
        int count =  rrmUsersMapper.checkUsername(itemCode, rrmUsers.getUsername(), null);
        if (count > 0) {
            return ResultVO.badRequest("用户名已经存在！");
        }
        bindUserUtil.bindCreateUserInfo(rrmUsers);
        rrmUsersMapper.insert(rrmUsers);
        return ResultVO.success(rrmUsers.getId());
    }

    @Override
    public ResultVO<String> deleteUsersById(String id) {
        RrmUsers rrmUsers = new RrmUsers();
        rrmUsers.setId(id);
        rrmUsers.setUpdatedAt(LocalDateTime.now());
        rrmUsers.setAccountStatus((byte)0);
        rrmUsersMapper.updateById(rrmUsers);
        return ResultVO.success(rrmUsers.getId());
    }

    @Override
    public ResultVO<String> updateUsersById(RrmUsers rrmUsers) {
        String itemCode = jwtTokenUtil.getItemCode();
        int count =  rrmUsersMapper.checkUsername(itemCode, rrmUsers.getUsername(), rrmUsers.getId());
        if (count > 0) {
            return ResultVO.badRequest("用户名已经存在！");
        }
        rrmUsers.setUpdatedAt(LocalDateTime.now());
        rrmUsersMapper.updateById(rrmUsers);
        return ResultVO.success(rrmUsers.getId());
    }

    @Override
    public ResultVO<RrmUsers> getUsersById(String id) {
        return ResultVO.success(rrmUsersMapper.selectById(id));
    }

    @Override
    public ResultVO<PageResultVO<RrmUsersVO>> searchUsersPage(RrmUsersDTO dto) {
        dto.setItemCode(jwtTokenUtil.getItemCode());
        IPage<RrmUsersVO> pageVo = rrmUsersMapper.searchUsersPage(dto.getPage(RrmUsersVO.class), dto);
        return ResultVO.successPage(pageVo);
    }
}
