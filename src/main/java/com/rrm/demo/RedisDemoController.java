package com.rrm.demo;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis测试类.
 *
 * @author TWL 2025/1/10 10:27
 * @since 1.0
 */
@ApiOperation("redis测试类")
@RestController
@RequestMapping("/redis/demo")
public class RedisDemoController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @ApiOperation(value = "测试客户端连接情况")
    @GetMapping("/t1")
    public void t1() {
        // 存储数据
        redisTemplate.opsForValue().set("testKey", "Hello, Redis!");

        // 获取数据
        String value = (String) redisTemplate.opsForValue().get("testKey");
        System.out.println("Value: " + value);

        // 删除数据
        redisTemplate.delete("testKey");
    }
}
