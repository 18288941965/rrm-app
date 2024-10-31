package com.rrm.module.api.controller;

import com.rrm.annotations.PermissionRequired;
import com.rrm.module.api.dto.ApiScannerDTO;
import com.rrm.module.api.service.ApiScannerService;
import com.rrm.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述.
 *
 * @author TWL 2024/10/30 16:46
 * @since 1.0
 */
@ApiOperation("资源扫描")
@RestController
@RequestMapping("/scanner")
public class ApiScannerController {

    @Autowired
    private ApiScannerService apiScannerService;

    // 用于验证前端请求是否有效
    private final static String API_KEY = "YX1pe3Ur6bUauw4eKt4HZxV3S264HjJDrJQ39cqktRCiVPJ5a1RdPTfLHP88zXcq";

    @PostMapping("/run")
    @ApiOperation("资源扫描-执行")
    @PermissionRequired(value = PermissionRequired.AuthCodeEnum.LOGIN)
    public ResultVO<Void> run(@RequestBody ApiScannerDTO apiScannerDTO) {
        if (!API_KEY.equals(apiScannerDTO.getApiKey())) {
            return ResultVO.badRequest("无效的apiKey");
        }
        return apiScannerService.run(apiScannerDTO);
    }
}
