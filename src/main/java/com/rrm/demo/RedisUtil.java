package com.rrm.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 类描述.
 *
 * @author TWL 2025/1/10 15:51
 * @since 1.0
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 添加数据到redis中
     * @param key 存储在 Redis 中的对象键
     * @param obj 存储在 Redis 中的对象值
     */
    public void setObjectToRedis(String key, Object obj) {
        redisTemplate.opsForValue().set(key, obj);
    }

    /**
     * 添加数据到redis中
     * @param key 存储在 Redis 中的对象键
     * @param obj 存储在 Redis 中的对象值
     * @param timeout 超时时间
     * @param unit 超时时间单位
     */
    public void setObjectToRedis(String key, Object obj, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, obj, timeout, unit);
    }

    /**
     * 根据给定的 key 从 Redis 中获取指定类型的对象。
     *
     * @param key   存储在 Redis 中的对象键
     * @param clazz 对象的类型
     * @param <T>   泛型类型参数
     * @return 返回从 Redis 中获取的对象，如果不存在则返回 null
     */
    public <T> T getObjectFromRedis(String key, Class<T> clazz) {
        Object value = redisTemplate.opsForValue().get(key);
        return clazz.isInstance(value) ? clazz.cast(value) : null;
    }
}
