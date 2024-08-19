package com.rrm.module.dict.dto;

import com.rrm.util.PageBase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RrmDictItemDTO extends PageBase {

    /**
     * 字典类型编码
     */
    private String typeCode;

    /**
     * 字典名称
     */
    private String itemName;

    /**
     * 字典代码
     */
    private String itemCode;

}