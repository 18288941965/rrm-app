package com.rrm.module.org.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rrm.module.org.domain.model.RrmOrg;
import com.rrm.module.org.dto.RrmOrgDTO;
import com.rrm.module.org.mapper.RrmOrgMapper;
import com.rrm.module.org.service.RrmOrgService;
import com.rrm.module.users.domain.model.RrmUsers;
import com.rrm.util.BindUserUtil;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 机构管理.
 *
 * @author TWL 2024/9/5 15:37
 * @since 1.0
 */
@Service
public class RrmOrgServiceImpl implements RrmOrgService {

    @Autowired
    private RrmOrgMapper rrmOrgMapper;

    @Autowired
    private BindUserUtil bindUserUtil;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public ResultVO<String> createOrg(RrmOrg rrmOrg) {
        bindUserUtil.bindCreateUserInfo(rrmOrg);
        rrmOrgMapper.insert(rrmOrg);
        return ResultVO.success(rrmOrg.getId());
    }

    @Override
    public ResultVO<String> deleteOrgById(String id) {
        RrmOrg rrmOrg = new RrmOrg();
        rrmOrg.setId(id);
        rrmOrg.setUpdatedAt(LocalDateTime.now());
        rrmOrg.setIsDeleted((byte)1);
        rrmOrg.setDeletedAt(LocalDateTime.now());
        rrmOrgMapper.updateById(rrmOrg);
        return ResultVO.success(rrmOrg.getId());
    }

    @Override
    public ResultVO<String> updateOrgById(RrmOrg rrmOrg) {
        rrmOrg.setUpdatedAt(LocalDateTime.now());
        rrmOrgMapper.updateById(rrmOrg);
        return ResultVO.success(rrmOrg.getId());
    }

    @Override
    public ResultVO<RrmOrg> getOrgById(String id) {
        return ResultVO.success(rrmOrgMapper.selectById(id));
    }

    @Override
    public ResultVO<PageResultVO<RrmOrg>> searchOrgPage(RrmOrgDTO dto) {
        dto.setItemCode(jwtTokenUtil.getItemCode());
        IPage<RrmOrg> pageVo = rrmOrgMapper.searchOrgPage(dto.getPage(RrmOrg.class), dto);
        return ResultVO.successPage(pageVo);
    }
}
