package com.rrm.module.role.controller;

import com.rrm.module.role.domain.model.RrmRole;
import com.rrm.module.role.domain.vo.RrmRoleVO;
import com.rrm.module.role.dto.RrmRoleDTO;
import com.rrm.module.role.service.RrmRoleService;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色管理.
 *
 * @author TWL 2024/8/2 15:08
 * @since 1.0
 */
@ApiOperation(value = "角色管理")
@RestController
@RequestMapping("/role")
public class RrmRoleController {

    @Autowired
    private RrmRoleService rrmRoleService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/page")
    public ResultVO<PageResultVO<RrmRoleVO>> searchRolePage(@RequestBody RrmRoleDTO dto) {
        return rrmRoleService.searchRolePage(dto);
    }

    @ApiOperation(value = "创建")
    @PostMapping
    public ResultVO<String> createRole(@RequestBody RrmRole rrmRole) {
        return rrmRoleService.createRole(rrmRole);
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public ResultVO<String> updateRole(@RequestBody RrmRole rrmRole) {
        return rrmRoleService.updateRoleById(rrmRole);
    }

    @ApiOperation(value = "更新状态")
    @PutMapping("/status")
    public ResultVO<String> updateRoleStatus(@RequestBody RrmRole rrmRole) {
        return rrmRoleService.updateRoleById(rrmRole);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResultVO<String> deleteRole(@PathVariable String id) {
        return rrmRoleService.deleteRoleById(id);
    }

    @ApiOperation(value = "根据ID获取")
    @GetMapping("/{id}")
    public ResultVO<RrmRole> getRole(@PathVariable String id) {
        return rrmRoleService.getRoleById(id);
    }
}
