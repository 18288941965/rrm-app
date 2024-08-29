package com.rrm.module.menu.controller;

import com.rrm.module.menu.domain.model.RrmMenuElement;
import com.rrm.module.menu.service.RrmMenuElementService;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TWL 2024/8/8 15:57
 * @since 1.0
 */
@ApiOperation(value = "菜单控件管理")
@RestController
@RequestMapping("/menu-element")
public class RrmMenuElementController {

    @Autowired
    private RrmMenuElementService rrmMenuElementService;

    @ApiOperation(value = "根据菜单id查询元素")
    @GetMapping("/{menuId}/children")
    public ResultVO<List<RrmMenuElement>> getMenuElementByMenuId(@PathVariable String menuId) {
        return rrmMenuElementService.getMenuElementByMenuId(menuId);
    }

    @ApiOperation(value = "根据ID查询元素")
    @GetMapping("/{id}")
    public ResultVO<RrmMenuElement> getMenuElement(@PathVariable String id) {
        return rrmMenuElementService.getMenuElementById(id);
    }

    @ApiOperation(value = "创建菜单元素")
    @PostMapping
    public ResultVO<String> createMenuElement(@RequestBody RrmMenuElement menuElement) {
        return rrmMenuElementService.createMenuElement(menuElement);
    }

    @ApiOperation(value = "更新菜单元素")
    @PutMapping
    public ResultVO<String> updateMenuElement(@RequestBody RrmMenuElement menuElement) {
        return rrmMenuElementService.updateMenuElementById(menuElement);
    }

    @ApiOperation(value = "删除菜单元素")
    @DeleteMapping("/{id}")
    public ResultVO<Void> deleteMenuElement(@PathVariable String id) {
        return rrmMenuElementService.deleteMenuElementById(id);
    }
}
