package com.rrm.module.dict.controller;

import com.rrm.module.dict.service.RrmDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字典项.
 *
 * @author TWL 2024/8/8 15:57
 * @since 1.0
 */
@RestController
@RequestMapping("/dict/item")
public class RrmDictItemController {

    @Autowired
    private RrmDictItemService rrmDictItemService;
}
