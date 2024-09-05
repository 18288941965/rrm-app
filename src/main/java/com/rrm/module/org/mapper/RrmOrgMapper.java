package com.rrm.module.org.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rrm.module.org.domain.model.RrmOrg;
import com.rrm.module.org.dto.RrmOrgDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RrmOrgMapper extends BaseMapper<RrmOrg> {

    IPage<RrmOrg> searchOrgPage(Page<RrmOrg> page, @Param("dto") RrmOrgDTO dto);
}