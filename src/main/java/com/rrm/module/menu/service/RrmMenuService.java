package com.rrm.module.menu.service;

import com.rrm.module.menu.domain.model.RrmMenu;
import com.rrm.module.menu.domain.vo.RrmMenuVO;
import com.rrm.vo.ResultVO;

import java.util.List;

/**
 * 接口描述.
 *
 * @author TWL 2024/8/8 15:57
 * @since 1.0
 */
public interface RrmMenuService {

    ResultVO<RrmMenuVO> getMenuById(String id);

    ResultVO<String> createMenu(RrmMenu menu);

    ResultVO<String> updateMenuById(RrmMenu menu);

    ResultVO<Void> deleteMenuById(String id);

    ResultVO<List<RrmMenuVO>> getMenuTreeByItemCode();
}
