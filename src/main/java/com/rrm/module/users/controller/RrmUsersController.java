package com.rrm.module.users.controller;

import com.rrm.module.users.domain.model.RrmUsers;
import com.rrm.module.users.dto.RrmUsersDTO;
import com.rrm.module.users.service.RrmUsersService;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理.
 *
 * @author TWL 2024/9/5 15:38
 * @since 1.0
 */
@ApiOperation(value = "用户管理")
@RestController
@RequestMapping("/users")
public class RrmUsersController {

    @Autowired
    private RrmUsersService rrmUsersService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/page")
    public ResultVO<PageResultVO<RrmUsers>> searchUsersPage(@RequestBody RrmUsersDTO dto) {
        return rrmUsersService.searchUsersPage(dto);
    }

    @ApiOperation(value = "创建")
    @PostMapping
    public ResultVO<String> createUsers(@RequestBody RrmUsers rrmUsers) {
        return rrmUsersService.createUsers(rrmUsers);
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public ResultVO<String> updateUsers(@RequestBody RrmUsers rrmUsers) {
        return rrmUsersService.updateUsersById(rrmUsers);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResultVO<String> deleteUsers(@PathVariable String id) {
        return rrmUsersService.deleteUsersById(id);
    }

    @ApiOperation(value = "根据ID获取")
    @GetMapping("/{id}")
    public ResultVO<RrmUsers> getUsers(@PathVariable String id) {
        return rrmUsersService.getUsersById(id);
    }
}