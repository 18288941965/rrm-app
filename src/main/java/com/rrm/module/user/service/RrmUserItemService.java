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

    ResultVO<Integer> deleteUserItem(Integer userId, String itemCode);

    ResultVO<Integer> createUserItem(RrmUserItem rrmUserItem);
}
