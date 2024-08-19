package com.rrm.module.dict.controller;

import com.rrm.module.dict.domain.model.RrmDictItem;
import com.rrm.module.dict.domain.vo.RrmDictItemVO;
import com.rrm.module.dict.dto.RrmDictItemDTO;
import com.rrm.module.dict.service.RrmDictItemService;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 字典项.
 *
 * @author TWL 2024/8/8 15:57
 * @since 1.0
 */
@RestController
@RequestMapping("/dict-item")
public class RrmDictItemController {

    @Autowired
    private RrmDictItemService rrmDictItemService;

    // 分页查询
    @PostMapping("/page")
    public ResultVO<PageResultVO<RrmDictItemVO>> searchDictItemPage(@RequestBody RrmDictItemDTO dto) {
        return rrmDictItemService.searchDictItemPage(dto);
    }

    // 根据ID查询字典
    @GetMapping("/{id}")
    public ResultVO<RrmDictItem> getDictItem(@PathVariable Long id) {
        return rrmDictItemService.getDictItemById(id);
    }

    // 创建新的字典
    @PostMapping
    public ResultVO<Long> createDictItem(@RequestBody RrmDictItem dictItem) {
        return rrmDictItemService.createDictItem(dictItem);
    }

    // 更新字典
    @PutMapping
    public ResultVO<Long> updateDictItem(@RequestBody RrmDictItem rrmDictItem) {
        return rrmDictItemService.updateDictItemById(rrmDictItem);
    }

    // 删除字典
    @DeleteMapping("/{id}")
    public ResultVO<Void> deleteDictItem(@PathVariable Long id) {
        return rrmDictItemService.deleteDictItemById(id);
    }
}
