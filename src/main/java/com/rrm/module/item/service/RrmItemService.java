package com.rrm.module.item.service;

import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.module.item.domain.vo.RrmItemVO;
import com.rrm.vo.ResultVO;

import java.util.List;

/**
 * 项目管理.
 * 创建时间：2024/7/29 15:36
 *
 * @author TWL
 * @since 1.0
 */
public interface RrmItemService {

    ResultVO<String> createItem(RrmItem rrmItem);

    int countByItemCode(String itemCode);

    ResultVO<String> deleteItemAndAssociations(Integer id);

    ResultVO<String> updateItemById(RrmItem rrmItem);

    ResultVO<List<RrmItemVO>> getAllItem();

    ResultVO<RrmItem> getItemById(String id);

    ResultVO<List<String>> getCorrelationUserId(String itemCode);
}
