package com.rrm.module.menu.controller;

import com.rrm.module.menu.domain.model.RrmMenuResource;
import com.rrm.module.menu.dto.RrmMenuResourceDTO;
import com.rrm.module.menu.service.RrmMenuResourceService;
import com.rrm.module.resource.domain.vo.RrmResourceVO;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TWL 2024/8/8 15:57
 * @since 1.0
 */
@ApiOperation(value = "菜单绑定资源")
@RestController
@RequestMapping("/menu-resource")
public class RrmMenuResourceController {

    @Autowired
    private RrmMenuResourceService rrmMenuResourceService;


    @ApiOperation(value = "绑定")
    @PostMapping
    public ResultVO<String> bindMenuResource(@RequestBody RrmMenuResource menuResource) {
        return rrmMenuResourceService.bindMenuResource(menuResource);
    }

    @ApiOperation(value = "查询绑定数据")
    @GetMapping("/{menuId}")
    public ResultVO<List<RrmResourceVO>> getMenuBindResourceByMenuId(@PathVariable String menuId) {
        return rrmMenuResourceService.getMenuBindResourceByMenuId(menuId);
    }

    @ApiOperation(value = "统计绑定数据量")
    @GetMapping("/count/{menuId}")
    public ResultVO<Integer> countMenuBindResourceByMenuId(@PathVariable String menuId) {
        return rrmMenuResourceService.countMenuBindResourceByMenuId(menuId);
    }

    @ApiOperation(value = "取消绑定")
    @DeleteMapping("/{menuId}/{resourceId}")
    public ResultVO<Void> unbindMenuResource(@PathVariable String menuId, @PathVariable String resourceId) {
        RrmMenuResourceDTO dto = new RrmMenuResourceDTO();
        dto.setMenuId(menuId);
        dto.setResourceId(resourceId);
        return rrmMenuResourceService.unbindMenuResource(dto);
    }
}
