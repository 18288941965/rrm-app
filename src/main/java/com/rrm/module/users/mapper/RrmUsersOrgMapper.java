package com.rrm.module.users.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrm.module.org.domain.bo.RrmOrgBO;
import com.rrm.module.users.domain.model.RrmUsersOrg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RrmUsersOrgMapper extends BaseMapper<RrmUsersOrg> {

    void batchInsert(List<RrmUsersOrg> list);

    void batchDelete(String usersId);

    List<RrmOrgBO> selectByUsersId(String usersId);

    void updateDefaultLogin(@Param("dto") RrmUsersOrg rrmUsersOrg);

    void cleanDefaultLogin(String usersId);
}