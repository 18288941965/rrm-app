package com.rrm.module.users.service;

import com.rrm.module.role.domain.model.RrmRole;
import com.rrm.module.users.domain.model.RrmUsersRole;
import com.rrm.vo.ResultVO;

import java.util.List;

/**
 * 用户角色关联表.
 *
 * @author TWL 2024/9/5 15:39
 * @since 1.0
 */
public interface RrmUsersRoleService {

    ResultVO<List<RrmRole>> getUsersBindRoleByUserId(String usersId);

    ResultVO<String> bindUsersRole(RrmUsersRole rrmUsersRole);

    ResultVO<Void> unbindUsersRole(String usersId, String roleId);

}
