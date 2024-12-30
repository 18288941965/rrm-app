package com.rrm.module.dict.domain.vo;

import com.rrm.module.dict.domain.model.RrmDictEntry;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 * 字典项
 */
@Getter
@Setter
public class RrmDictEntryVO extends RrmDictEntry {

    // 父字典项名称
    private String parentItemName;

    // 状态名称
    private String statusName;

}