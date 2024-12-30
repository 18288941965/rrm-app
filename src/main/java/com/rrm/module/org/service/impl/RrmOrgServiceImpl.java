package com.rrm.module.org.service.impl;

import com.rrm.module.org.domain.model.RrmOrg;
import com.rrm.module.org.domain.vo.RrmOrgVO;
import com.rrm.module.org.mapper.RrmOrgMapper;
import com.rrm.module.org.service.RrmOrgService;
import com.rrm.util.BindUserUtil;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        LocalDateTime now = LocalDateTime.now();
        RrmOrg rrmOrg = new RrmOrg();
        rrmOrg.setId(id);
        rrmOrg.setUpdatedAt(now);
        rrmOrg.setIsDeleted((byte)1);
        rrmOrg.setDeletedAt(now);
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

    public static List<RrmOrgVO> buildOrgTree(List<RrmOrgVO> orgList) {
        Map<String, RrmOrgVO> orgMap = new HashMap<>();
        List<RrmOrgVO> rootOrgList = new ArrayList<>();

        // Step 1: 将所有菜单存入 map，key 为机构的 code
        for (RrmOrgVO org : orgList) {
            orgMap.put(org.getCode(), org);
        }

        // Step 2: 构建树结构
        for (RrmOrgVO org : orgList) {
            if (!orgMap.containsKey(org.getParentCode())) {
                rootOrgList.add(org);
            } else {
                // 否则，将其添加到对应的父节点的 children 列表中
                RrmOrgVO parentOrg = orgMap.get(org.getParentCode());
                if (parentOrg != null) {
                    parentOrg.getChildren().add(org);
                }
            }
        }
        return rootOrgList;
    }

    @Override
    public ResultVO<List<RrmOrgVO>> getOrgTreeByItemCode() {
        List<RrmOrgVO> dataList = rrmOrgMapper.selectOrgByItemCodeOrId(jwtTokenUtil.getItemCode(), null);
        List<RrmOrgVO> rrmOrgVOList = buildOrgTree(dataList);
        return ResultVO.success(rrmOrgVOList);
    }
}
