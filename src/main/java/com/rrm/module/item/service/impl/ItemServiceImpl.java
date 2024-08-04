package com.rrm.module.item.service.impl;

import com.rrm.cache.RrmUserCache;
import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.module.item.domain.vo.RrmItemVO;
import com.rrm.module.item.mapper.RrmItemMapper;
import com.rrm.module.item.service.ItemService;
import com.rrm.module.user.domain.model.RrmUserItem;
import com.rrm.module.user.mapper.RrmUserItemMapper;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private RrmUserItemMapper rrmUserItemMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    @Transactional
    public ResultVO<String> createItem(RrmItem rrmItem) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        rrmItem.setCreateTime(LocalDateTime.now());
        rrmItem.setUserId(userInfo.getId());
        itemMapper.insert(rrmItem);

        // 插入用户项目关联
        RrmUserItem userItem = new RrmUserItem();
        userItem.setUserId(userInfo.getId());
        userItem.setItemId(rrmItem.getId());
        rrmUserItemMapper.insert(userItem);

        return ResultVO.success();
    }

    @Override
    public int countByCode(String itemCode) {
        return itemMapper.countByCode(itemCode);
    }

    @Override
    @Transactional
    public ResultVO<String> deleteItem(Integer id) {
        itemMapper.deleteById(id);
        rrmUserItemMapper.deleteByItemCode(id);
        return ResultVO.success();
    }

    @Override
    public ResultVO<String> updateItem(RrmItem rrmItem) {
        itemMapper.updateById(rrmItem);
        return ResultVO.success();
    }

    @Override
    public ResultVO<List<RrmItemVO>> getAllItem() {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        List<RrmItemVO> itemList = itemMapper.getItemByUserId(userInfo.getId());
        return ResultVO.success(itemList);
    }

    @Override
    public ResultVO<RrmItem> getItemById(Integer id) {
        return ResultVO.success(itemMapper.selectById(id));
    }
}
