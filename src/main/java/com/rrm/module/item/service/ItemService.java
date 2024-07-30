package com.rrm.module.item.service;

import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.vo.ResultVO;

import java.util.List;

/**
 * 项目管理.
 * 创建时间：2024/7/29 15:36
 *
 * @author TWL
 * @since 1.0
 */
public interface ItemService {

    ResultVO<String> createItem(RrmItem rrmItem);

    ResultVO<String> deleteItem(String id);

    ResultVO<String> updateItem(RrmItem rrmItem);

    ResultVO<List<RrmItem>> getAllItem();
}
