package com.rrm.module.dict.domain.vo;

import com.rrm.module.dict.domain.model.RrmDictType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 字典项返回页面类.
 *
 * @author TWL 2024/8/12 11:14
 * @since 1.0
 */
@Getter
@Setter
public class RrmDictTypeVO extends RrmDictType {

    /**
     * 字典子项统计
     */
    private Integer entryCount;
}
