package com.rrm.cache;

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
    public RrmUserCache cacheUser(String username, RrmUserCache user) {
        return user;
    }

    @Cacheable(value = "users", key = "#username")
    public RrmUserCache getCachedUser(String username) {
        return null; // 如果缓存中没有用户信息，会返回 null
    }

}
