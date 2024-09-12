package com.rrm.module.dict.controller;

import com.rrm.module.dict.domain.model.RrmDictEntry;
import com.rrm.module.dict.domain.vo.RrmDictEntryVO;
import com.rrm.module.dict.domain.vo.RrmDictVO;
import com.rrm.module.dict.dto.RrmDictEntryDTO;
import com.rrm.module.dict.service.RrmDictEntryService;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典项.
 *
 * @author TWL 2024/8/8 15:57
 * @since 1.0
 */
@ApiOperation(value = "字典项")
@RestController
@RequestMapping("/dict-entry")
public class RrmDictEntryController {

    @Autowired
    private RrmDictEntryService rrmDictEntryService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/page")
    public ResultVO<PageResultVO<RrmDictEntryVO>> searchDictEntryPage(@RequestBody RrmDictEntryDTO dto) {
        return rrmDictEntryService.searchDictEntryPage(dto);
    }

    @ApiOperation(value = "根据ID查询字典")
    @GetMapping("/{id}")
    public ResultVO<RrmDictEntry> getDictEntry(@PathVariable Long id) {
        return rrmDictEntryService.getDictEntryById(id);
    }

    @ApiOperation(value = "根据字典类型代码查询字典")
    @GetMapping("/subitems/{typeCode}")
    public ResultVO<List<RrmDictEntry>> getDictEntryByTypeCode(@PathVariable String typeCode) {
        return rrmDictEntryService.getDictEntryByTypeCode(typeCode);
    }

    @ApiOperation(value = "根据字典类型代码查询字典")
    @GetMapping("/select/{typeCode}")
    public ResultVO<List<RrmDictVO>> selectDictEntryByTypeCode(@PathVariable String typeCode) {
        return rrmDictEntryService.selectDictEntryByTypeCode(typeCode);
    }

    @ApiOperation(value = "创建新的字典")
    @PostMapping
    public ResultVO<Long> createDictEntry(@RequestBody RrmDictEntry dictEntry) {
        return rrmDictEntryService.createDictEntry(dictEntry);
    }

    @ApiOperation(value = "更新字典")
    @PutMapping
    public ResultVO<Long> updateDictEntry(@RequestBody RrmDictEntry rrmDictEntry) {
        return rrmDictEntryService.updateDictEntryById(rrmDictEntry);
    }

    @ApiOperation(value = "更新字典顺序")
    @PutMapping("/sort")
    public ResultVO<Void> updateDictEntrySort(@RequestBody List<RrmDictEntry> entryList) {
        return rrmDictEntryService.updateDictEntrySort(entryList);
    }

    @ApiOperation(value = "更新字典状态")
    @PutMapping("/status")
    public ResultVO<Void> updateDictEntryStatus(@RequestBody RrmDictEntry rrmDictEntry) {
        return rrmDictEntryService.updateEntryStatus(rrmDictEntry.getStatus(), rrmDictEntry.getId());
    }

    @ApiOperation(value = "删除字典")
    @DeleteMapping("/{id}")
    public ResultVO<Void> deleteDictEntry(@PathVariable Long id) {
        return rrmDictEntryService.deleteDictEntryById(id);
    }
}
