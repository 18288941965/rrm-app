package com.rrm.module.user.controller;

import com.rrm.module.user.domain.model.RrmUserItem;
import com.rrm.module.user.service.RrmUserItemService;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息管理.
 *
 * @author TWL 2024/8/2 15:08
 * @since 1.0
 */
@RestController
@RequestMapping("/user-item")
public class RrmUserItemController {

    @Autowired
    private RrmUserItemService rrmUserItemService;

    @DeleteMapping("/{userId}/{itemId}")
    public ResultVO<String> deleteUserItem(@PathVariable Integer userId, @PathVariable Integer itemId) {
        rrmUserItemService.deleteUserItem(userId, itemId);
        return ResultVO.success();
    }

    @PostMapping
    public ResultVO<String> createUserItem(@RequestBody RrmUserItem rrmUserItem) {
        return rrmUserItemService.createUserItem(rrmUserItem);
    }
}
