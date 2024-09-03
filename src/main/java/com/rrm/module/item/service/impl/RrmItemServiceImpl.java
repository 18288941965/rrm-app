package com.rrm.module.item.service.impl;

import com.rrm.cache.RrmUserCache;
import com.rrm.module.item.domain.model.RrmItem;
import com.rrm.module.item.domain.vo.RrmItemVO;
import com.rrm.module.item.mapper.RrmItemMapper;
import com.rrm.module.item.service.RrmItemService;
import com.rrm.module.user.domain.model.RrmUser;
import com.rrm.module.user.domain.model.RrmUserItem;
import com.rrm.module.user.mapper.RrmUserItemMapper;
import com.rrm.module.user.mapper.RrmUserMapper;
import com.rrm.util.BindUserUtil;
import com.rrm.util.JwtTokenUtil;
import com.rrm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目管理.
 * 创建时间：2024/7/29 15:37
 *
 * @author TWL
 * @since 1.0
 */
@Service
public class RrmItemServiceImpl implements RrmItemService {

    @Autowired
    private RrmItemMapper itemMapper;

    @Autowired
    private RrmUserMapper userMapper;

    @Autowired
    private RrmUserItemMapper rrmUserItemMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private BindUserUtil bindUserUtil;

    @Override
    @Transactional
    public ResultVO<String> createItem(RrmItem rrmItem) {
        bindUserUtil.bindCreateUserInfo(rrmItem);
        itemMapper.insert(rrmItem);

        // 插入用户项目关联
        RrmUserItem userItem = new RrmUserItem();
        userItem.setUserId(rrmItem.getCreatedBy());
        userItem.setItemId(rrmItem.getId());
        rrmUserItemMapper.insert(userItem);

        return ResultVO.success();
    }

    @Override
    public int countByItemCode(String itemCode) {
        return itemMapper.countByItemCode(itemCode);
    }

    @Override
    @Transactional
    public ResultVO<String> deleteItemAndAssociations(Integer id) {
        itemMapper.deleteById(id);
        rrmUserItemMapper.deleteByItemId(id);
        return ResultVO.success();
    }

    @Override
    public ResultVO<String> updateItemById(RrmItem rrmItem) {
        bindUserUtil.bindUpdateUserInfo(rrmItem);
        itemMapper.updateById(rrmItem);
        return ResultVO.success();
    }

    @Override
    public ResultVO<List<RrmItemVO>> getAllItem() {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();

        // 获取所有项目
        List<RrmItemVO> itemList = itemMapper.getItemAll();
        // 项目用户关联关系
        List<RrmUserItem> rrmUserItems = rrmUserItemMapper.selectList(null);
        // 所有用户
        List<RrmUser> rrmUsers = userMapper.getAllUser2();

        itemList.forEach(item -> {
            // 项目关联的userIdList
            List<Integer> userIdList = rrmUserItems
                    .stream()
                    .filter(rrmUserItem -> item.getId().equals(rrmUserItem.getItemId()))
                    .map(RrmUserItem::getUserId)
                    .collect(Collectors.toList());

            List<RrmUser> correlationUser = rrmUsers
                    .stream()
                    .filter(user -> userIdList.contains(user.getId()))
                    .collect(Collectors.toList());
            item.setUserList(correlationUser);

            item.setLoginId(userInfo.getId());
        });

        return ResultVO.success(itemList);
    }

    @Override
    public ResultVO<RrmItem> getItemById(Integer id) {
        return ResultVO.success(itemMapper.selectById(id));
    }

    @Override
    public ResultVO<List<Integer>> getCorrelationUserId(Integer id) {
        return ResultVO.success(rrmUserItemMapper.getCorrelationUserId(id));
    }
}
