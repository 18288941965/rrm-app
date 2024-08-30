package com.rrm.module.resource.controller;

import com.rrm.module.resource.service.RrmResourceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 资源管理.
 *
 * @author TWL 2024/8/2 15:08
 * @since 1.0
 */
@ApiOperation(value = "资源管理")
@RestController
@RequestMapping("/resource")
public class RrmResourceController {

    @Autowired
    private RrmResourceService rrmResourceService;

}
