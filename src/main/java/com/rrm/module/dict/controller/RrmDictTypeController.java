package com.rrm.module.dict.controller;

import com.rrm.module.dict.domain.model.RrmDictType;
import com.rrm.module.dict.domain.vo.RrmDictTypeVO;
import com.rrm.module.dict.dto.RrmDictTypeDTO;
import com.rrm.module.dict.service.RrmDictTypeService;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 字典类型.
 *
 * @author TWL 2024/8/8 15:57
 * @since 1.0
 */
@RestController
@RequestMapping("/dict-type")
public class RrmDictTypeController {

    @Autowired
    private RrmDictTypeService rrmDictTypeService;

    // 分页查询
    @PostMapping("/page")
    public ResultVO<PageResultVO<RrmDictTypeVO>> searchDictTypePage(@RequestBody RrmDictTypeDTO dto) {
        return rrmDictTypeService.searchDictTypePage(dto);
    }

    // 根据ID查询字典类型
    @GetMapping("/{id}")
    public ResultVO<RrmDictType> getDictType(@PathVariable Long id) {
        return rrmDictTypeService.getDictTypeById(id);
    }

    // 创建新的字典类型
    @PostMapping
    public ResultVO<Long> createDictType(@RequestBody RrmDictType dictType) {
        return rrmDictTypeService.createDictType(dictType);
    }

    // 更新字典类型
    @PutMapping
    public ResultVO<Long> updateDictType(@RequestBody RrmDictType rrmDictType) {
        return rrmDictTypeService.updateDictTypeById(rrmDictType);
    }

    // 删除字典类型
    @DeleteMapping("/{id}")
    public ResultVO<Void> deleteDictType(@PathVariable Long id) {
        return rrmDictTypeService.deleteDictTypeById(id);
    }
}
