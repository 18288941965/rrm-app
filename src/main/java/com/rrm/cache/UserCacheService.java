package com.rrm.cache;

import com.rrm.module.user.domain.model.RrmUser;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 缓存用户信息.
 *
 * @author TWL 2024/7/30 15:13
 * @since 1.0
 */
@Service
public class UserCacheService {

    @CachePut(value = "users", key = "#username")
    public RrmUser cacheUser(String username, RrmUser user) {
        return user;
    }

    @Cacheable(value = "users", key = "#username")
    public RrmUser getCachedUser(String username) {
        return null; // 如果缓存中没有用户信息，会返回 null
    }
}
