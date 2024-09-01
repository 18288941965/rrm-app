package com.rrm.module.resource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rrm.module.resource.domain.model.RrmResource;
import com.rrm.module.resource.dto.RrmResourceDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RrmResourceMapper extends BaseMapper<RrmResource> {

    IPage<RrmResource> searchResourcePage(Page<RrmResource> page, @Param("dto") RrmResourceDTO dto);
}