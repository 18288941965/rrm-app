package com.rrm.module.role.controller;

import com.rrm.module.role.domain.model.RrmRoleMenu;
import com.rrm.module.role.service.RrmRoleMenuService;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色菜单（元素）关联.
 *
 * @author TWL 2024/8/2 15:08
 * @since 1.0
 */
@ApiOperation(value = "角色绑定菜单")
@RestController
@RequestMapping("/role-menu")
public class RrmRoleMenuController {

    @Autowired
    private RrmRoleMenuService rrmRoleMenuService;

    @ApiOperation(value = "绑定")
    @PostMapping
    public ResultVO<String> bindRoleMenu(@RequestBody RrmRoleMenu rrmRoleMenu) {
        return rrmRoleMenuService.bindRoleMenu(rrmRoleMenu);
    }

    @ApiOperation(value = "查询绑定数据")
    @GetMapping("/{roleId}")
    public ResultVO<List<RrmRoleMenu>> getRoleBindMenuByRoleId(@PathVariable String roleId) {
        return rrmRoleMenuService.getRoleBindMenuByRoleId(roleId);
    }

    @ApiOperation(value = "取消绑定")
    @DeleteMapping("/{roleId}/{menuId}/{type}")
    public ResultVO<List<String>> unbindMenuResource(@PathVariable String roleId, @PathVariable String menuId, @PathVariable String type) {
        return rrmRoleMenuService.unbindRoleMenu(roleId, menuId, type);
    }
}
