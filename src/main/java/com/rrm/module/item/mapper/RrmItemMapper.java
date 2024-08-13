package com.rrm.module.item.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.module.item.domain.vo.RrmItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 项目Mapper.
 * 创建时间：2024/7/29 15:38
 *
 * @author TWL
 * @since 1.0
 */
@Mapper
public interface RrmItemMapper extends BaseMapper<RrmItem> {

    /**
     * 根据用户信息获取相关的项目
     * @return List<RrmItemVO>
     */
    List<RrmItemVO> getItemAll();

    /**
     * 根据代码统计
     * @param itemCode 项目代码
     * @return 统计数量
     */
    int countByItemCode(String itemCode);
}
