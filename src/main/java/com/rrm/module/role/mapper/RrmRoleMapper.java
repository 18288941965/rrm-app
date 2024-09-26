package com.rrm.module.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rrm.module.role.domain.model.RrmRole;
import com.rrm.module.role.domain.vo.RrmRoleVO;
import com.rrm.module.role.dto.RrmRoleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RrmRoleMapper extends BaseMapper<RrmRole> {

    IPage<RrmRoleVO> searchRolePage(Page<RrmRoleVO> page, @Param("dto") RrmRoleDTO dto);

    List<RrmRole> getUsersBindRoleByUserId(String usersId);
}