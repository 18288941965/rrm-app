package com.rrm.module.users.controller;

import com.rrm.module.role.domain.model.RrmRole;
import com.rrm.module.users.dto.RrmUsersRoleDTO;
import com.rrm.module.users.service.RrmUsersRoleService;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户角色关联.
 *
 * @author TWL 2024/9/5 15:38
 * @since 1.0
 */
@ApiOperation(value = "用户角色关联")
@RestController
@RequestMapping("/users-role")
public class RrmUsersRoleController {

    @Autowired
    private RrmUsersRoleService rrmUsersRoleService;

    @ApiOperation(value = "绑定")
    @PostMapping
    public ResultVO<Void> bindUsersRole(@RequestBody RrmUsersRoleDTO rrmUsersRoleDTO) {
        return rrmUsersRoleService.bindUsersRole(rrmUsersRoleDTO);
    }

    @ApiOperation(value = "查询绑定数据")
    @GetMapping("/{usersId}/{roleId}")
    public ResultVO<List<RrmRole>> getUsersBindRole(@PathVariable String usersId, @PathVariable String roleId) {
        return rrmUsersRoleService.getUsersBindRole(usersId, roleId);
    }
}
