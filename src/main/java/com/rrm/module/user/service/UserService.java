package com.rrm.module.user.service;

import com.rrm.module.user.domain.model.RrmUser;
import com.rrm.vo.ResultVO;

import java.util.List;

/**
 * 用户信息管理.
 *
 * @author TWL 2024/7/30 8:56
 * @since 1.0
 */
public interface UserService {

    RrmUser getUserByName(String username);

    ResultVO<String> createUser(RrmUser rrmUser);

    ResultVO<String> deleteUser(String id);

    ResultVO<String> updateUser(RrmUser rrmUser);

    ResultVO<List<RrmUser>> getAllUser();

}
