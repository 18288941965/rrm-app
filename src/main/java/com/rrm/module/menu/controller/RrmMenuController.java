package com.rrm.module.menu.controller;

import com.rrm.module.menu.domain.model.RrmMenu;
import com.rrm.module.menu.domain.vo.RrmMenuVO;
import com.rrm.module.menu.service.RrmMenuService;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述.
 *
 * @author TWL 2024/8/8 15:57
 * @since 1.0
 */
@RestController
@RequestMapping("/menu")
public class RrmMenuController {

    @Autowired
    private RrmMenuService rrmMenuService;

    // 根据关联项目查询所有菜单并构建为tree
    @GetMapping("/tree")
    public ResultVO<List<RrmMenuVO>> getMenuTreeByItemCode() {
        return rrmMenuService.getMenuTreeByItemCode();
    }

    // 根据ID查询
    @GetMapping("/{id}")
    public ResultVO<RrmMenuVO> getMenu(@PathVariable String id) {
        return rrmMenuService.getMenuById(id);
    }

    // 创建菜单
    @PostMapping
    public ResultVO<String> createMenu(@RequestBody RrmMenu menu) {
        return rrmMenuService.createMenu(menu);
    }

    // 更新菜单
    @PutMapping
    public ResultVO<String> updateMenu(@RequestBody RrmMenu menu) {
        return rrmMenuService.updateMenuById(menu);
    }

    // 删除菜单
    @DeleteMapping("/{id}")
    public ResultVO<Void> deleteMenu(@PathVariable String id) {
        return rrmMenuService.deleteMenuById(id);
    }
}
