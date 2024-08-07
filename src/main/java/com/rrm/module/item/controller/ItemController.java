package com.rrm.module.item.controller;

import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.module.item.domain.vo.RrmItemVO;
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
        int i = itemService.countByCode(rrmItem.getItemCode());
        if (i > 0) {
            return ResultVO.conflict("项目代码已经存在！");
        }
        return itemService.createItem(rrmItem);
    }

    @DeleteMapping("/{id}")
    public ResultVO<String> deleteItem(@PathVariable Integer id) {
        return itemService.deleteItem(id);
    }

    @PutMapping
    public ResultVO<String> updateItem(@RequestBody RrmItem rrmItem) {
        return itemService.updateItem(rrmItem);
    }

    @GetMapping("/{id}")
    public ResultVO<RrmItem> getItemById(@PathVariable Integer id) {
        return itemService.getItemById(id);
    }

    @GetMapping
    public ResultVO<List<RrmItemVO>> getAllItem() {
        return itemService.getAllItem();
    }

    @GetMapping("/correlationUserId/{id}")
    public ResultVO<List<Integer>> getCorrelationUserId(@PathVariable Integer id) {
        return itemService.getCorrelationUserId(id);
    }
}
