package com.rrm.module.org.service;

import com.rrm.module.org.domain.model.RrmOrg;
import com.rrm.module.org.dto.RrmOrgDTO;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;

/**
 * 机构管理.
 *
 * @author TWL 2024/9/5 15:36
 * @since 1.0
 */
public interface RrmOrgService {

    ResultVO<String> createOrg(RrmOrg rrmOrg);

    ResultVO<String> deleteOrgById(String id);

    ResultVO<String> updateOrgById(RrmOrg rrmOrg);

    ResultVO<RrmOrg> getOrgById(String id);

    ResultVO<PageResultVO<RrmOrg>> searchOrgPage(RrmOrgDTO dto);
}
