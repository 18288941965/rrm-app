package com.rrm.module.user.controller;

import com.rrm.module.user.domain.model.RrmUserItem;
import com.rrm.module.user.service.RrmUserItemService;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息管理.
 *
 * @author TWL 2024/8/2 15:08
 * @since 1.0
 */
@ApiOperation(value = "用户项目关联")
@RestController
@RequestMapping("/user-item")
public class RrmUserItemController {

    @Autowired
    private RrmUserItemService rrmUserItemService;

    @ApiOperation(value = "删除关联信息")
    @DeleteMapping("/{userId}/{itemId}")
    public ResultVO<Integer> deleteUserItem(@PathVariable Integer userId, @PathVariable Integer itemId) {
        return rrmUserItemService.deleteUserItem(userId, itemId);
    }

    @ApiOperation(value = "创建关联信息")
    @PostMapping
    public ResultVO<Integer> createUserItem(@RequestBody RrmUserItem rrmUserItem) {
        return rrmUserItemService.createUserItem(rrmUserItem);
    }
}
