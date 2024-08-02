package com.rrm.module.user.controller;

import com.rrm.module.user.domain.model.RrmUser;
import com.rrm.module.user.service.UserService;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息管理.
 *
 * @author TWL 2024/8/2 15:08
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResultVO<String> createUser(@RequestBody RrmUser rrmUser) {
        return userService.createUser(rrmUser);
    }

    @DeleteMapping("/{id}")
    public ResultVO<String> deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }

    @PutMapping
    public ResultVO<String> updateUser(@RequestBody RrmUser rrmUser) {
        return userService.updateUser(rrmUser);
    }

    @GetMapping
    public ResultVO<List<RrmUser>> getAllItem() {
        return userService.getAllUser();
    }
}
