package com.rrm.module.user.service.impl;

import com.rrm.module.user.domain.model.RrmUserItem;
import com.rrm.module.user.mapper.RrmUserItemMapper;
import com.rrm.module.user.service.RrmUserItemService;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户项目关联.
 *
 * @author TWL 2024/7/30 8:56
 * @since 1.0
 */
@Service
public class RrmUserItemServiceImpl implements RrmUserItemService {


    @Autowired
    private RrmUserItemMapper rrmUserItemMapper;


    @Override
    public ResultVO<Integer> deleteUserItem(Integer userId, String itemCode) {
        int i = rrmUserItemMapper.deleteUserItem(userId, itemCode);
        return ResultVO.success(i);
    }

    @Override
    public ResultVO<Integer> createUserItem(RrmUserItem rrmUserItem) {
        return ResultVO.success(rrmUserItemMapper.insert(rrmUserItem));
    }
}
