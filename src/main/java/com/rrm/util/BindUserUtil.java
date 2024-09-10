package com.rrm.util;

import com.rrm.base.ModelInfo;
import com.rrm.cache.RrmUserCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 类描述.
 *
 * @author TWL 2024/8/30 17:26
 * @since 1.0
 */
@Component
public class BindUserUtil {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public void bindCreateUserInfo(ModelInfo obj) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        obj.setCreatedBy(userInfo.getId());
        obj.setCreatedAt(LocalDateTime.now());
        obj.setItemCode(userInfo.getItemCode());
    }

    public void bindCreateUserInfoExcludeItemCode(ModelInfo obj) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        obj.setCreatedBy(userInfo.getId());
        obj.setCreatedAt(LocalDateTime.now());
    }

    public void bindUpdateUserInfo(ModelInfo obj) {
        RrmUserCache userInfo = jwtTokenUtil.getUserInfo();
        obj.setUpdatedBy(userInfo.getId());
        obj.setUpdatedAt(LocalDateTime.now());
    }
}
