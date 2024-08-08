package com.rrm.module.user.service;

import com.rrm.module.user.domain.model.RrmUserItem;
import com.rrm.vo.ResultVO;

/**
 * 用户项目关联.
 *
 * @author TWL 2024/7/30 8:56
 * @since 1.0
 */
public interface RrmUserItemService {

    int deleteUserItem(Integer userId, Integer itemId);

    ResultVO<String> createUserItem(RrmUserItem rrmUserItem);
}
