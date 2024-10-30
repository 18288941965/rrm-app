package com.rrm.module.api.domain.bo;

import lombok.Data;

/**
 * 接口扫描-授权对象.
 *
 * @author TWL 2024/10/30 16:50
 * @since 1.0
 */
@Data
public class ApiScannerBO {

    private String annotationValue;
    private String authCode;

    public ApiScannerBO(String annotationValue, String authCode) {
        this.annotationValue = annotationValue;
        this.authCode = authCode;
    }
}
