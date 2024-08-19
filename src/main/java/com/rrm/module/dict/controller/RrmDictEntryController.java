package com.rrm.module.dict.controller;

import com.rrm.module.dict.domain.model.RrmDictEntry;
import com.rrm.module.dict.domain.vo.RrmDictEntryVO;
import com.rrm.module.dict.dto.RrmDictEntryDTO;
import com.rrm.module.dict.service.RrmDictEntryService;
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
@RequestMapping("/dict-entry")
public class RrmDictEntryController {

    @Autowired
    private RrmDictEntryService rrmDictEntryService;

    // 分页查询
    @PostMapping("/page")
    public ResultVO<PageResultVO<RrmDictEntryVO>> searchDictEntryPage(@RequestBody RrmDictEntryDTO dto) {
        return rrmDictEntryService.searchDictEntryPage(dto);
    }

    // 根据ID查询字典
    @GetMapping("/{id}")
    public ResultVO<RrmDictEntry> getDictEntry(@PathVariable Long id) {
        return rrmDictEntryService.getDictEntryById(id);
    }

    // 创建新的字典
    @PostMapping
    public ResultVO<Long> createDictEntry(@RequestBody RrmDictEntry dictEntry) {
        return rrmDictEntryService.createDictEntry(dictEntry);
    }

    // 更新字典
    @PutMapping
    public ResultVO<Long> updateDictEntry(@RequestBody RrmDictEntry rrmDictEntry) {
        return rrmDictEntryService.updateDictEntryById(rrmDictEntry);
    }

    // 删除字典
    @DeleteMapping("/{id}")
    public ResultVO<Void> deleteDictEntry(@PathVariable Long id) {
        return rrmDictEntryService.deleteDictEntryById(id);
    }
}
