package com.rrm.module.item.controller;

import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.module.item.domain.vo.RrmItemVO;
import com.rrm.module.item.service.RrmItemService;
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
public class RrmItemController {

    @Autowired
    private RrmItemService rrmItemService;

    @PostMapping
    public ResultVO<String> createItem(@RequestBody RrmItem rrmItem) {
        int i = rrmItemService.countByCode(rrmItem.getItemCode());
        if (i > 0) {
            return ResultVO.conflict("项目代码已经存在！");
        }
        return rrmItemService.createItem(rrmItem);
    }

    @DeleteMapping("/{id}")
    public ResultVO<String> deleteItem(@PathVariable Integer id) {
        return rrmItemService.deleteItem(id);
    }

    @PutMapping
    public ResultVO<String> updateItem(@RequestBody RrmItem rrmItem) {
        return rrmItemService.updateItem(rrmItem);
    }

    @GetMapping("/{id}")
    public ResultVO<RrmItem> getItemById(@PathVariable Integer id) {
        return rrmItemService.getItemById(id);
    }

    @GetMapping
    public ResultVO<List<RrmItemVO>> getAllItem() {
        return rrmItemService.getAllItem();
    }

    @GetMapping("/correlationUserId/{id}")
    public ResultVO<List<Integer>> getCorrelationUserId(@PathVariable Integer id) {
        return rrmItemService.getCorrelationUserId(id);
    }
}
