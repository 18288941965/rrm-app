package com.rrm.module.item.controller;

import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.module.item.service.ItemService;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目管理.
 * 创建时间：2024/7/29 15:35
 *
 * @author TWL
 * @since 1.0
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;


    @PostMapping
    public ResultVO<String> createItem(@RequestBody RrmItem rrmItem) {
        return itemService.createItem(rrmItem);
    }

    @DeleteMapping("/{id}")
    public ResultVO<String> deleteItem(@PathVariable String id) {
        return itemService.deleteItem(id);
    }

    @PutMapping
    public ResultVO<String> updateItem(@RequestBody RrmItem rrmItem) {
        return itemService.updateItem(rrmItem);
    }

    @GetMapping
    public ResultVO<List<RrmItem>> getAllItem() {
        return itemService.getAllItem();
    }
}
