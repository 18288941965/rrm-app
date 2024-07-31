package com.rrm.module.item.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.module.item.domain.vo.RrmItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 项目管理.
 * 创建时间：2024/7/29 15:38
 *
 * @author TWL
 * @since 1.0
 */
@Mapper
public interface RrmItemMapper extends BaseMapper<RrmItem> {

    /**
     * 根据用户信息获取相关的项目
     * @param userId 用户ID
     * @return List<RrmItemVO>
     */
    List<RrmItemVO> getItemByUserId(Integer userId);
}
