package com.rrm.module.user.controller;

import cn.hutool.crypto.SecureUtil;
import com.rrm.module.user.domain.model.RrmUser;
import com.rrm.module.user.domain.vo.RrmUserVO;
import com.rrm.module.user.dto.RrmUserDTO;
import com.rrm.module.user.service.RrmUserService;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息管理.
 *
 * @author TWL 2024/8/2 15:08
 * @since 1.0
 */
@ApiOperation(value = "用户信息管理")
@RestController
@RequestMapping("/user")
public class RrmUserController {

    @Autowired
    private RrmUserService rrmUserService;

    @ApiOperation(value = "创建")
    @PostMapping
    public ResultVO<String> createUser(@RequestBody RrmUser rrmUser) {
        return rrmUserService.createUser(rrmUser);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResultVO<String> deleteUser(@PathVariable Integer id) {
        return rrmUserService.deleteUserAndAssociations(id);
    }

    @ApiOperation(value = "修改用户描述")
    @PutMapping("/description")
    public ResultVO<String> updateUserDescription(@RequestBody RrmUser rrmUser) {
        return rrmUserService.updateUserDescription(rrmUser);
    }

    @ApiOperation(value = "修改密码")
    @PutMapping("/password")
    public ResultVO<String> updateUserPassword(@RequestBody RrmUserVO rrmUserVO) {
        return rrmUserService.updateUserPassword(rrmUserVO);
    }

    @ApiOperation(value = "验证密码")
    @PostMapping("/validatePass")
    public ResultVO<Boolean> validatePass(@RequestBody RrmUserDTO userDTO) {
        RrmUser user = rrmUserService.getUserByName(userDTO.getUsername());
        String s = SecureUtil.md5(userDTO.getPassword());
        return ResultVO.success(s.equals(user.getPassword()));
    }

    @ApiOperation(value = "根据ID获取")
    @GetMapping("/{id}")
    public ResultVO<RrmUser> getUser(@PathVariable Integer id) {
        return rrmUserService.getUserById(id);
    }

    @ApiOperation(value = "查询所有")
    @GetMapping
    public ResultVO<List<RrmUserVO>> getAllUser() {
        return rrmUserService.getAllUser();
    }

    @ApiOperation(value = "查询所有基本信息")
    @GetMapping("/allUserBase")
    public ResultVO<List<RrmUserVO>> getAllUserBase() {
        return rrmUserService.getAllUserBase();
    }
}
