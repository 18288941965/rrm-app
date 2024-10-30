package com.rrm.module.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 接口扫描请求参数.
 *
 * @author TWL 2024/10/30 16:53
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ApiScannerDTO {

    /*
     * 扫描的微服务
     */
    private String microservice;

    /*
     * apiKey 用来验证请求接口是否合法
     */
    private String apiKey;
}
