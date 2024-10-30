package com.rrm.module.api.service;

import com.rrm.module.api.dto.ApiScannerDTO;
import com.rrm.vo.ResultVO;

/**
 * 接口扫描.
 *
 * @author TWL 2024/10/30 16:48
 * @since 1.0
 */
public interface ApiScannerService {

    ResultVO<Void> run(ApiScannerDTO apiScannerDTO);
}
