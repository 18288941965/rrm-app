package com.rrm.module.menu.controller;

import com.rrm.module.menu.domain.model.RrmMenu;
import com.rrm.module.menu.domain.vo.RrmMenuVO;
import com.rrm.module.menu.dto.RrmMenuMoveDTO;
import com.rrm.module.menu.service.RrmMenuService;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TWL 2024/8/8 15:57
 * @since 1.0
 */
@ApiOperation(value = "菜单管理")
@RestController
@RequestMapping("/menu")
public class RrmMenuController {

    @Autowired
    private RrmMenuService rrmMenuService;

    @ApiOperation(value = "根据关联项目查询所有菜单并构建为tree")
    @GetMapping("/tree")
    public ResultVO<List<RrmMenuVO>> getMenuTreeByItemCode() {
        return rrmMenuService.getMenuTreeByItemCode();
    }

    @ApiOperation(value = "根据ID查询")
    @GetMapping("/{id}")
    public ResultVO<RrmMenuVO> getMenu(@PathVariable String id) {
        return rrmMenuService.getMenuById(id);
    }

    @ApiOperation(value = "根据parentId查询子菜单")
    @GetMapping("/children/{parentId}")
    public ResultVO<List<RrmMenu>> getMenuByParentId(@PathVariable String parentId) {
        return rrmMenuService.getMenuByParentId(parentId);
    }

    @ApiOperation(value = "根据项目统计菜单项")
    @GetMapping("/count")
    public ResultVO<Long> countByItemCode() {
        return rrmMenuService.countByItemCode();
    }

    @ApiOperation(value = "创建菜单")
    @PostMapping
    public ResultVO<String> createMenu(@RequestBody RrmMenu menu) {
        return rrmMenuService.createMenu(menu);
    }

    @ApiOperation(value = "更新菜单")
    @PutMapping
    public ResultVO<String> updateMenu(@RequestBody RrmMenu menu) {
        return rrmMenuService.updateMenuById(menu);
    }

    @ApiOperation(value = "菜单排序")
    @PutMapping("/sort")
    public ResultVO<Void> updateMenuSort(@RequestBody List<RrmMenu> menuList) {
        return rrmMenuService.updateMenuSort(menuList);
    }

    @ApiOperation(value = "移动菜单")
    @PutMapping("/move")
    public ResultVO<Void> updateMenuParent(@RequestBody RrmMenuMoveDTO menuMoveDTO) {
        return rrmMenuService.batchUpdateMenuParent(menuMoveDTO);
    }

    @ApiOperation(value = "删除菜单")
    @DeleteMapping("/{id}")
    public ResultVO<Void> deleteMenu(@PathVariable String id) {
        return rrmMenuService.deleteMenuById(id);
    }
}
