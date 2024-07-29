package com.rrm.module.item.service;

import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.vo.ReturnT;

import java.util.List;

/**
 * 项目管理.
 * 创建时间：2024/7/29 15:36
 *
 * @author TWL
 * @since 1.0
 */
public interface ItemService {

    /**
     * 创建项目
     * @param rrmItem bean
     * @return ReturnT<String>
     */
    ReturnT<String> createItem(RrmItem rrmItem);

    ReturnT<String> deleteItem(String id);

    ReturnT<String> updateItem(RrmItem rrmItem);

    ReturnT<List<RrmItem>> getAllItem();
}
