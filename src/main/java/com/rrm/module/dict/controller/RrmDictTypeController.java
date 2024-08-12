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
@RequestMapping("/dict/type")
public class RrmDictTypeController {

    @Autowired
    private RrmDictTypeService rrmDictTypeService;

    // 分页查询
    @PostMapping("/pagination")
    public ResultVO<PageResultVO<RrmDictTypeVO>> searchWithPagination(@RequestBody RrmDictTypeDTO dto) {
        return rrmDictTypeService.searchWithPagination(dto);
    }

    // 根据ID查询字典类型
    @GetMapping("/{id}")
    public ResultVO<RrmDictType> getDictTypeById(@PathVariable Long id) {
        return ResultVO.success(rrmDictTypeService.findById(id));
    }

    // 创建新的字典类型
    @PostMapping
    public ResultVO<RrmDictType> createDictType(@RequestBody RrmDictType dictType) {
        rrmDictTypeService.save(dictType);
        return ResultVO.success();
    }

    // 更新字典类型
    @PutMapping
    public ResultVO<RrmDictType> updateDictType(@RequestBody RrmDictType rrmDictType) {
        rrmDictTypeService.updateDictType(rrmDictType);
        return ResultVO.success();
    }

    // 删除字典类型
    @DeleteMapping("/{id}")
    public ResultVO<Void> deleteDictType(@PathVariable Long id) {
        rrmDictTypeService.deleteById(id);
        return ResultVO.success();
    }
}
