package com.rrm.module.resource.service.impl;

import com.rrm.module.resource.mapper.RrmResourceMapper;
import com.rrm.module.resource.service.RrmResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类描述.
 *
 * @author TWL 2024/8/30 12:38
 * @since 1.0
 */
@Service
public class RrmResourceServiceImpl implements RrmResourceService {

    @Autowired
    private RrmResourceMapper rrmResourceMapper;
}
