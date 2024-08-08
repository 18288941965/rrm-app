package com.rrm.module.menu.mapper;

import com.rrm.module.menu.domain.model.RrmMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface RrmMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(RrmMenu record);

    int insertSelective(RrmMenu record);

    RrmMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RrmMenu record);

    int updateByPrimaryKey(RrmMenu record);
}