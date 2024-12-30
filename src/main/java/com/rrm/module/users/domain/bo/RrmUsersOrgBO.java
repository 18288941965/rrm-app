package com.rrm.module.users.domain.bo;

import lombok.Data;

/**
 * 用户关联的机构信息.
 *
 * @author TWL 2024/12/26 15:32
 * @since 1.0
 */
@Data
public class RrmUsersOrgBO {

    /**
     * 任职机构代码
     */
    private String orgCode;

    /**
     * 任职机构名称
     */
    private String orgName;
}
