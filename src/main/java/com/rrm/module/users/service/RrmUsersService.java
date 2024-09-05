package com.rrm.module.users.service;

import com.rrm.module.users.domain.model.RrmUsers;
import com.rrm.module.users.dto.RrmUsersDTO;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;

/**
 * 用户管理.
 *
 * @author TWL 2024/9/5 15:39
 * @since 1.0
 */
public interface RrmUsersService {

    ResultVO<String> createUsers(RrmUsers rrmUsers);

    ResultVO<String> deleteUsersById(String id);

    ResultVO<String> updateUsersById(RrmUsers rrmUsers);

    ResultVO<RrmUsers> getUsersById(String id);

    ResultVO<PageResultVO<RrmUsers>> searchUsersPage(RrmUsersDTO dto);
}
