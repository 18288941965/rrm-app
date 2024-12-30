package com.rrm.module.users.dto;

import com.rrm.util.PageBase;
import lombok.Getter;
import lombok.Setter;

/**
 * 类描述.
 *
 * @author TWL 2024/9/5 15:44
 * @since 1.0
 */
@Getter
@Setter
public class RrmUsersDTO extends PageBase {

    private String itemCode;
    private String status;
    private String username;
    private String name;
    private String orgCode;
    private String orgName;
}
