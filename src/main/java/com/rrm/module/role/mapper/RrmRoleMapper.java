package com.rrm.module.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rrm.module.role.domain.model.RrmRole;
import com.rrm.module.role.dto.RrmRoleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RrmRoleMapper extends BaseMapper<RrmRole> {

    IPage<RrmRole> searchRolePage(Page<RrmRole> page, @Param("dto") RrmRoleDTO dto);
}