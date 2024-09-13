package com.rrm.module.resource.service;

import com.rrm.module.resource.domain.model.RrmResource;
import com.rrm.module.resource.domain.vo.RrmResourceVO;
import com.rrm.module.resource.dto.RrmResourceDTO;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;

import java.util.List;

/**
 * 接口描述.
 *
 * @author TWL 2024/8/30 12:36
 * @since 1.0
 */
public interface RrmResourceService {

    ResultVO<Integer> batchInsertResource(List<RrmResource> list);

    ResultVO<PageResultVO<RrmResourceVO>> searchResourcePage(RrmResourceDTO dto);

    ResultVO<String> updateResourceStatus(RrmResource resource);
}
