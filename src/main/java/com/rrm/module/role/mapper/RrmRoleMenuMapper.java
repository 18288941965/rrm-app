package com.rrm.module.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrm.module.role.domain.model.RrmRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RrmRoleMenuMapper extends BaseMapper<RrmRoleMenu> {

    List<RrmRoleMenu> getBindMenuIds(String roleId);

    int deleteByRoleIdAndMenuId(String roleId, String menuId);

    void deleteByRoleId(String roleId);

    void deleteByMenuId(String menuId);
}