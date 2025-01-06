package com.rrm.module.users.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrm.module.users.domain.model.RrmUsersRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RrmUsersRoleMapper extends BaseMapper<RrmUsersRole> {

    void batchInsert(List<RrmUsersRole> usersRoleList);

    void deleteByUsersId(String usersId);

    void deleteByRoleId(String roleId);

    void deleteByOrgId(String orgId);
}