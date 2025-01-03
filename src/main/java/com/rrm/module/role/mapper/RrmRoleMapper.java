package com.rrm.module.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrm.module.role.domain.model.RrmRole;
import com.rrm.module.role.domain.vo.RrmRoleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RrmRoleMapper extends BaseMapper<RrmRole> {

    List<RrmRoleVO> selectRoleByItemCodeOrId(String itemCode, String id);

    List<RrmRole> getUsersBindRoleByUserId(String usersId);
}