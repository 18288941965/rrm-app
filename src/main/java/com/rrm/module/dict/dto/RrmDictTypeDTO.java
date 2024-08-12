package com.rrm.module.dict.dto;

import com.rrm.util.PageBase;
import lombok.Getter;
import lombok.Setter;

/**
 * rrm_dict_type
 */
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

}