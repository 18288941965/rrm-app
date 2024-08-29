package com.rrm.module.menu.service;

import com.rrm.module.menu.domain.model.RrmMenuElement;
import com.rrm.vo.ResultVO;

import java.util.List;

/**
 * 接口描述.
 *
 * @author TWL 2024/8/8 15:57
 * @since 1.0
 */
public interface RrmMenuElementService {

    ResultVO<List<RrmMenuElement>> getMenuElementByMenuId(String MenuId);

    ResultVO<RrmMenuElement> getMenuElementById(String id);

    ResultVO<String> createMenuElement(RrmMenuElement menuElement);

    ResultVO<String> updateMenuElementById(RrmMenuElement menuElement);

    ResultVO<Void> deleteMenuElementById(String id);

}
