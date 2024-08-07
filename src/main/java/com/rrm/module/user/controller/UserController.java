package com.rrm.module.user.controller;

import cn.hutool.crypto.SecureUtil;
import com.rrm.module.user.domain.model.RrmUser;
import com.rrm.module.user.domain.vo.RrmUserVO;
import com.rrm.module.user.dto.RrmUserDTO;
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
    public ResultVO<String> deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/comment")
    public ResultVO<String> updateUserComment(@RequestBody RrmUser rrmUser) {
        return userService.updateUserComment(rrmUser);
    }

    @PutMapping("/password")
    public ResultVO<String> updateUserPassword(@RequestBody RrmUserVO rrmUserVO) {
        return userService.updateUserPassword(rrmUserVO);
    }

    @PostMapping("/validatePass")
    public ResultVO<Boolean> validatePass(@RequestBody RrmUserDTO userDTO) {
        RrmUser user = userService.getUserByName(userDTO.getUsername());
        String s = SecureUtil.md5(userDTO.getPassword());
        return ResultVO.success(s.equals(user.getPassword()));
    }

    @GetMapping("/{id}")
    public ResultVO<RrmUser> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public ResultVO<List<RrmUserVO>> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/allUserBase")
    public ResultVO<List<RrmUserVO>> getAllUserBase() {
        return userService.getAllUserBase();
    }
}
