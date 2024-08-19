package com.rrm.module.dict.dto;

import com.rrm.util.PageBase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RrmDictEntryDTO extends PageBase {

    /**
     * 字典类型编码
     */
    private Integer typeId;

    /**
     * 字典名称
     */
    private String entryName;

    /**
     * 字典代码
     */
    private String entryCode;

}