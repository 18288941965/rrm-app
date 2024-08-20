package com.rrm.module.dict.dto;

import com.rrm.util.PageBase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RrmDictTypeDTO extends PageBase {

    /**
     * 字典类型编码
     */
    private String typeCode;

    /**
     * 字典类型名称
     */
    private String typeName;

    /**
     * 项目代码
     */
    private String itemCode;

}