package com.rrm.module.item.service.impl;

import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.module.item.mapper.RrmItemMapper;
import com.rrm.module.item.service.ItemService;
import com.rrm.vo.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public ReturnT<String> createItem(RrmItem rrmItem) {
        itemMapper.insert(rrmItem);
        return ReturnT.SUCCESS;
    }

    @Override
    public ReturnT<String> deleteItem(String id) {
        itemMapper.deleteById(id);
        return ReturnT.SUCCESS;
    }

    @Override
    public ReturnT<String> updateItem(RrmItem rrmItem) {
        itemMapper.updateById(rrmItem);
        return ReturnT.SUCCESS;
    }

    @Override
    public ReturnT<List<RrmItem>> getAllItem() {
        List<RrmItem> rrmItems = itemMapper.selectList(null);
        ReturnT<List<RrmItem>> returnT = new ReturnT<>();
        returnT.setData(rrmItems);
        return returnT;
    }
}
