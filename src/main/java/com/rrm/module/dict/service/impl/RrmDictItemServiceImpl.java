package com.rrm.module.dict.service.impl;

import com.rrm.module.dict.mapper.RrmDictItemMapper;
import com.rrm.module.dict.service.RrmDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 字典项.
 *
 * @author TWL 2024/8/12 10:28
 * @since 1.0
 */
@Service
public class RrmDictItemServiceImpl implements RrmDictItemService {

    @Autowired
    private RrmDictItemMapper rrmDictItemMapper;
}
