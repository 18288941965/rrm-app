package com.rrm.module.dict.controller;

import com.rrm.module.dict.domain.model.RrmDictEntry;
import com.rrm.module.dict.domain.vo.RrmDictEntryVO;
import com.rrm.module.dict.domain.vo.RrmDictVO;
import com.rrm.module.dict.dto.RrmDictEntryDTO;
import com.rrm.module.dict.service.RrmDictEntryService;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 根据字典类型ID查询字典
    @GetMapping("/subitems/{typeId}")
    public ResultVO<List<RrmDictEntry>> getDictEntryByTypeId(@PathVariable Long typeId) {
        return rrmDictEntryService.getDictEntryByTypeId(typeId);
    }

    // 根据字典类型代码查询字典
    @GetMapping("/select/{typeCode}")
    public ResultVO<List<RrmDictVO>> getDictEntryByTypeCode(@PathVariable String typeCode) {
        return rrmDictEntryService.getDictEntryByTypeCode(typeCode);
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

    // 更新字典顺序
    @PutMapping("/sort")
    public ResultVO<Void> updateDictEntrySort(@RequestBody List<RrmDictEntry> entryList) {
        return rrmDictEntryService.updateDictEntrySort(entryList);
    }

    // 更新字典状态
    @PutMapping("/status")
    public ResultVO<Void> updateDictEntryStatus(@RequestBody RrmDictEntry rrmDictEntry) {
        return rrmDictEntryService.updateEntryStatus(rrmDictEntry.getStatus(), rrmDictEntry.getId());
    }

    // 删除字典
    @DeleteMapping("/{id}")
    public ResultVO<Void> deleteDictEntry(@PathVariable Long id) {
        return rrmDictEntryService.deleteDictEntryById(id);
    }
}
