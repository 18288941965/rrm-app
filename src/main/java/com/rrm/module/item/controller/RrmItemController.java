package com.rrm.module.item.controller;

import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.module.item.domain.vo.RrmItemVO;
import com.rrm.module.item.service.RrmItemService;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
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
@ApiOperation(value = "项目管理")
@RestController
@RequestMapping("/item")
public class RrmItemController {

    @Autowired
    private RrmItemService rrmItemService;

    @ApiOperation(value = "创建")
    @PostMapping
    public ResultVO<String> createItem(@RequestBody RrmItem rrmItem) {
        int i = rrmItemService.countByItemCode(rrmItem.getItemCode());
        if (i > 0) {
            return ResultVO.conflict("项目代码已经存在！");
        }
        return rrmItemService.createItem(rrmItem);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResultVO<String> deleteItem(@PathVariable Integer id) {
        return rrmItemService.deleteItemAndAssociations(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public ResultVO<String> updateItem(@RequestBody RrmItem rrmItem) {
        return rrmItemService.updateItemById(rrmItem);
    }

    @ApiOperation(value = "根据ID查询")
    @GetMapping("/{id}")
    public ResultVO<RrmItem> getItem(@PathVariable Integer id) {
        return rrmItemService.getItemById(id);
    }

    @ApiOperation(value = "查询所有")
    @GetMapping
    public ResultVO<List<RrmItemVO>> getAllItem() {
        return rrmItemService.getAllItem();
    }

    @ApiOperation(value = "获取项目关联的用户信息")
    @GetMapping("/correlationUserId/{itemCode}")
    public ResultVO<List<Integer>> getCorrelationUserId(@PathVariable String itemCode) {
        return rrmItemService.getCorrelationUserId(itemCode);
    }
}
