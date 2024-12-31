package com.rrm.module.org.controller;

import com.rrm.module.org.domain.model.RrmOrg;
import com.rrm.module.org.domain.vo.RrmOrgVO;
import com.rrm.module.org.dto.RrmOrgDTO;
import com.rrm.module.org.service.RrmOrgService;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 机构管理.
 *
 * @author TWL 2024/9/5 15:35
 * @since 1.0
 */

@ApiOperation(value = "机构管理")
@RestController
@RequestMapping("/org")
public class RrmOrgController {

    @Autowired
    private RrmOrgService rrmOrgService;

    @ApiOperation(value = "根据关联项目查询所有机构并构建为tree")
    @GetMapping("/tree")
    public ResultVO<List<RrmOrgVO>> getOrgTreeByItemCode() {
        return rrmOrgService.getOrgTreeByItemCode();
    }

    @ApiOperation(value = "创建")
    @PostMapping
    public ResultVO<String> createOrg(@RequestBody RrmOrg rrmOrg) {
        return rrmOrgService.createOrg(rrmOrg);
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public ResultVO<String> updateOrg(@RequestBody RrmOrg rrmOrg) {
        return rrmOrgService.updateOrgById(rrmOrg);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResultVO<String> deleteOrg(@PathVariable String id) {
        return rrmOrgService.deleteOrgById(id);
    }

    @ApiOperation(value = "根据ID获取")
    @GetMapping("/{id}")
    public ResultVO<RrmOrgVO> getOrg(@PathVariable String id) {
        return rrmOrgService.getOrgById(id);
    }
}
