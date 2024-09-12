package com.rrm.module.users.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rrm.module.users.domain.model.RrmUsers;
import com.rrm.module.users.domain.vo.RrmUsersVO;
import com.rrm.module.users.dto.RrmUsersDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RrmUsersMapper extends BaseMapper<RrmUsers> {

    IPage<RrmUsersVO> searchUsersPage(Page<RrmUsersVO> page, @Param("dto") RrmUsersDTO dto);

    int checkUsername(@Param("itemCode") String itemCode, @Param("username") String username, @Param("id") String id);
}