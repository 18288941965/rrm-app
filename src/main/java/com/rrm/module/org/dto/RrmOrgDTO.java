package com.rrm.module.org.dto;

import com.rrm.util.PageBase;
import lombok.Getter;
import lombok.Setter;

/**
 * 类描述.
 *
 * @author TWL 2024/9/5 15:46
 * @since 1.0
 */
@Getter
@Setter
public class RrmOrgDTO extends PageBase {

    private String id;
    private String itemCode;
    private String code;
    private String name;
}
