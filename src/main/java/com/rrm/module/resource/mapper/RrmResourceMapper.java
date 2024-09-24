package com.rrm.module.resource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rrm.module.resource.domain.model.RrmResource;
import com.rrm.module.resource.domain.vo.RrmResourceVO;
import com.rrm.module.resource.dto.RrmResourceDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RrmResourceMapper extends BaseMapper<RrmResource> {

    IPage<RrmResourceVO> searchResourcePage(Page<RrmResourceVO> page, @Param("dto") RrmResourceDTO dto);

    List<RrmResourceVO> getMenuBindResource(String menuId);

    Integer countMenuBindResource(String menuId);

    List<String> getServiceNameList(String itemCode);

    List<String> getPackageNameList(String itemCode);
}