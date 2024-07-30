package com.rrm.module.user.service;

import com.rrm.module.user.domain.model.RrmUser;

/**
 * 接口描述.
 *
 * @author TWL 2024/7/30 8:56
 * @since 1.0
 */
public interface UserService {

    RrmUser getUserByName(String username);
}
