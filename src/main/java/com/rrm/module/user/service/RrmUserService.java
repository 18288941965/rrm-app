package com.rrm.module.user.service;

import com.rrm.module.user.domain.model.RrmUser;
import com.rrm.module.user.domain.vo.RrmUserVO;
import com.rrm.vo.ResultVO;

import java.util.List;

/**
 * 用户信息管理.
 *
 * @author TWL 2024/7/30 8:56
 * @since 1.0
 */
public interface RrmUserService {

    RrmUser getUserByName(String username);

    ResultVO<String> createUser(RrmUser rrmUser);

    ResultVO<String> deleteUserAndAssociations(Integer id);

    ResultVO<String> updateUserDescription(RrmUser rrmUser);

    ResultVO<String> updateUserPassword( RrmUserVO rrmUserVO);

    ResultVO<List<RrmUserVO>> getAllUser();

    ResultVO<RrmUser> getUserById(Integer id);

    ResultVO<List<RrmUserVO>> getAllUserBase();
}
