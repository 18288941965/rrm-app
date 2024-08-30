package com.rrm.module.role.service;

import com.rrm.module.role.domain.model.RrmRole;
import com.rrm.vo.ResultVO;

/**
 * 用户信息管理.
 *
 * @author TWL 2024/7/30 8:56
 * @since 1.0
 */
public interface RrmRoleService {

    ResultVO<String> createRole(RrmRole rrmRole);

    ResultVO<String> deleteRoleById(String id);

    ResultVO<String> updateUserById(RrmRole rrmRole);

    ResultVO<RrmRole> getRoleById(String id);
}
