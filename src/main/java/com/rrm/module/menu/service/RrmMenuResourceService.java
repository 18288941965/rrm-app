package com.rrm.module.menu.service;

import com.rrm.module.menu.domain.model.RrmMenuResource;
import com.rrm.module.menu.dto.RrmMenuResourceDTO;
import com.rrm.module.resource.domain.vo.RrmResourceVO;
import com.rrm.vo.ResultVO;

import java.util.List;

/**
 * 菜单绑定资源.
 *
 * @author TWL 2024/8/8 15:57
 * @since 1.0
 */
public interface RrmMenuResourceService {

    ResultVO<List<RrmResourceVO>> getMenuBindResourceByMenuId(String menuId);

    ResultVO<String> bindMenuResource(RrmMenuResource menuResource);

    ResultVO<Void> unbindMenuResource(RrmMenuResourceDTO dto);

    ResultVO<Integer> countMenuBindResourceByMenuId(String menuId);
}
