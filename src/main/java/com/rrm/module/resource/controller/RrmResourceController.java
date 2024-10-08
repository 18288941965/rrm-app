package com.rrm.module.resource.controller;

import com.rrm.module.resource.domain.model.RrmResource;
import com.rrm.module.resource.domain.vo.RrmResourceVO;
import com.rrm.module.resource.domain.vo.TreeNode;
import com.rrm.module.resource.dto.RrmResourceDTO;
import com.rrm.module.resource.service.RrmResourceService;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源管理.
 *
 * @author TWL 2024/8/2 15:08
 * @since 1.0
 */
@ApiOperation(value = "资源管理")
@RestController
@RequestMapping("/resource")
public class RrmResourceController {

    @Autowired
    private RrmResourceService rrmResourceService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/page")
    public ResultVO<PageResultVO<RrmResourceVO>> searchResourcePage(@RequestBody RrmResourceDTO dto) {
        return rrmResourceService.searchResourcePage(dto);
    }

    @ApiOperation(value = "更新状态")
    @PutMapping("/status")
    public ResultVO<String> updateResourceStatus(@RequestBody RrmResource resource) {
        return rrmResourceService.updateResourceStatus(resource);
    }

    @ApiOperation(value = "统计资源数")
    @GetMapping("/count")
    public ResultVO<Long> countResourceByItemCode() {
        return rrmResourceService.countResourceByItemCode();
    }

    @ApiOperation(value = "去重查询所有微服务名")
    @GetMapping("/serviceNameList")
    public ResultVO<List<String>> getServiceNameList() {
        return rrmResourceService.getServiceNameList();
    }

    @ApiOperation(value = "构建包为树结构")
    @GetMapping("/packageNameByTree")
    public ResultVO<List<TreeNode>> getPackageNameByTree() {
        return rrmResourceService.getPackageNameByTree();
    }
}
