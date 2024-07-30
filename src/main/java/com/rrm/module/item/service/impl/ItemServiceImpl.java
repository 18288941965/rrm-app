package com.rrm.module.item.service.impl;

import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.module.item.mapper.RrmItemMapper;
import com.rrm.module.item.service.ItemService;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 项目管理.
 * 创建时间：2024/7/29 15:37
 *
 * @author TWL
 * @since 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RrmItemMapper itemMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public ResultVO<String> createItem(RrmItem rrmItem) {
        rrmItem.setCreateTime(LocalDateTime.now());
        rrmItem.setCreateUser(jwtTokenUtil.getUsernameFromRequest());
        itemMapper.insert(rrmItem);
        return ResultVO.success();
    }

    @Override
    public ResultVO<String> deleteItem(String id) {
        itemMapper.deleteById(id);
        return ResultVO.success();
    }

    @Override
    public ResultVO<String> updateItem(RrmItem rrmItem) {
        itemMapper.updateById(rrmItem);
        return ResultVO.success();
    }

    @Override
    public ResultVO<List<RrmItem>> getAllItem() {
        List<RrmItem> rrmItems = itemMapper.selectList(null);
        return ResultVO.success(rrmItems);
    }
}
