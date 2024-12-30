package com.rrm.module.dict.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rrm.module.dict.domain.model.RrmDictType;
import com.rrm.module.dict.domain.vo.RrmDictTypeVO;
import com.rrm.module.dict.dto.RrmDictTypeDTO;
import com.rrm.module.dict.mapper.RrmDictTypeMapper;
import com.rrm.module.dict.service.RrmDictTypeService;
import com.rrm.util.BindUserUtil;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.PageResultVO;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 字典类型.
 *
 * @author TWL 2024/8/12 10:29
 * @since 1.0
 */
@Service
public class RrmDictTypeServiceImpl implements RrmDictTypeService {

    @Autowired
    private RrmDictTypeMapper rrmDictTypeMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private BindUserUtil bindUserUtil;

    @Override
    public ResultVO<PageResultVO<RrmDictTypeVO>> searchDictTypePage(@RequestBody RrmDictTypeDTO dto) {
        dto.setItemCode(jwtTokenUtil.getItemCode());
        IPage<RrmDictTypeVO> pageVo = rrmDictTypeMapper.selectDictTypePage(dto.getPage(RrmDictTypeVO.class), dto);
        return ResultVO.successPage(pageVo);
    }

    @Override
    public ResultVO<RrmDictType> getDictTypeById(String id) {
        return ResultVO.success(rrmDictTypeMapper.selectById(id));
    }

    @Override
    public ResultVO<String> createDictType(RrmDictType dictType) {
        String itemCode = jwtTokenUtil.getItemCode();
        dictType.setItemCode(itemCode);

        int cnt = rrmDictTypeMapper.countByTypeCodeAndItemCode(dictType.getTypeCode(), itemCode);
        if (cnt > 0) {
            return ResultVO.badRequest("类型代码已经存在！");
        }
        bindUserUtil.bindCreateUserInfo(dictType);
        rrmDictTypeMapper.insert(dictType);
        return ResultVO.success(dictType.getId());
    }

    @Override
    public ResultVO<String> updateDictTypeById(RrmDictType rrmDictType) {
        bindUserUtil.bindUpdateUserInfo(rrmDictType);
        rrmDictTypeMapper.updateById(rrmDictType);
        return ResultVO.success(rrmDictType.getId());
    }

    @Override
    public ResultVO<Void> deleteDictTypeById(String id) {
        rrmDictTypeMapper.deleteById(id);
        return ResultVO.success();
    }
}
