package com.rrm.module.users.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rrm.cache.RrmUserCache;
import com.rrm.module.users.domain.model.RrmUsers;
import com.rrm.module.users.domain.model.RrmUsersOrg;
import com.rrm.module.users.domain.vo.RrmUsersVO;
import com.rrm.module.users.dto.RrmUsersDTO;
import com.rrm.module.users.mapper.RrmUsersMapper;
import com.rrm.module.users.mapper.RrmUsersOrgMapper;
import com.rrm.module.users.service.RrmUsersService;
import com.rrm.util.BindUserUtil;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private RrmUsersOrgMapper rrmUsersOrgMapper;

    @Autowired
    private BindUserUtil bindUserUtil;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private List<RrmUsersOrg> buildObject(RrmUsers rrmUsers) {
        List<RrmUsersOrg> rrmUsersOrgsList = new ArrayList<>();
        RrmUserCache rrmUserCache = bindUserUtil.getRrmUserCache();
        LocalDateTime now = LocalDateTime.now();
        rrmUsers.getOrgList().forEach(item -> {
            RrmUsersOrg bean = new RrmUsersOrg();
            bean.setId(DigestUtil.md5Hex(item.getId() + rrmUsers.getId()));
            bean.setCreatedBy(rrmUserCache.getId());
            bean.setCreatedAt(now);
            bean.setUsersId(rrmUsers.getId());
            bean.setOrgId(item.getId());
            bean.setItemCode(rrmUserCache.getItemCode());
            rrmUsersOrgsList.add(bean);
        });
        return rrmUsersOrgsList;
    }

    @Override
    @Transactional
    public ResultVO<String> createUsers(RrmUsers rrmUsers) {
        String itemCode = jwtTokenUtil.getItemCode();
        int count =  rrmUsersMapper.checkUsername(itemCode, rrmUsers.getUsername(), null);
        if (count > 0) {
            return ResultVO.badRequest("用户名已经存在！");
        }
        bindUserUtil.bindCreateUserInfo(rrmUsers);
        rrmUsersMapper.insert(rrmUsers);
        List<RrmUsersOrg> rrmUsersOrgs = buildObject(rrmUsers);
        if (!rrmUsersOrgs.isEmpty()) {
            rrmUsersOrgMapper.batchInsert(rrmUsersOrgs);
        }
        return ResultVO.success(rrmUsers.getId());
    }

    @Override
    public ResultVO<String> deleteUsersById(String id) {
        LocalDateTime now = LocalDateTime.now();
        RrmUsers rrmUsers = new RrmUsers();
        rrmUsers.setId(id);
        rrmUsers.setUpdatedAt(now);
        rrmUsers.setIsDeleted((byte)1);
        rrmUsers.setDeletedAt(now);
        rrmUsersMapper.updateById(rrmUsers);
        return ResultVO.success(rrmUsers.getId());
    }

    @Override
    @Transactional
    public ResultVO<String> updateUsersById(RrmUsers rrmUsers) {
        String itemCode = jwtTokenUtil.getItemCode();
        int count =  rrmUsersMapper.checkUsername(itemCode, rrmUsers.getUsername(), rrmUsers.getId());
        if (count > 0) {
            return ResultVO.badRequest("用户名已经存在！");
        }
        bindUserUtil.bindUpdateUserInfo(rrmUsers);
        rrmUsersMapper.updateById(rrmUsers);

        rrmUsersOrgMapper.batchDelete(rrmUsers.getId());
        List<RrmUsersOrg> rrmUsersOrgs = buildObject(rrmUsers);
        if (!rrmUsersOrgs.isEmpty()) {
            rrmUsersOrgMapper.batchInsert(rrmUsersOrgs);
        }

        return ResultVO.success(rrmUsers.getId());
    }

    @Override
    public ResultVO<RrmUsersVO> getUsersById(String id) {
        RrmUsersVO detailById = rrmUsersMapper.getDetailById(id);
        detailById.setOrgList(rrmUsersOrgMapper.selectByUsersId(id));
        return ResultVO.success(detailById);
    }

    @Override
    public ResultVO<PageResultVO<RrmUsersVO>> searchUsersPage(RrmUsersDTO dto) {
        dto.setItemCode(jwtTokenUtil.getItemCode());
        IPage<RrmUsersVO> pageVo = rrmUsersMapper.searchUsersPage(dto.getPage(RrmUsersVO.class), dto);
        pageVo.getRecords().forEach(item -> {
            item.setOrgList(rrmUsersOrgMapper.selectByUsersId(item.getId()));
        });
        return ResultVO.successPage(pageVo);
    }

    @Override
    @Transactional
    public ResultVO<Void> updateDefaultLoginOrg(RrmUsersOrg rrmUsersOrg) {
        rrmUsersOrgMapper.cleanDefaultLogin(rrmUsersOrg.getUsersId());
        rrmUsersOrgMapper.updateDefaultLogin(rrmUsersOrg);
        return ResultVO.success();
    }
}
