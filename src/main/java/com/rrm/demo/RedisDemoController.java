package com.rrm.demo;

import com.rrm.demo.model.RedisDemo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    private RedisUtil redisUtil;

    @ApiOperation(value = "测试客户端连接情况")
    @GetMapping("/t1")
    public void t1() {
        // 存储数据
        redisUtil.setObjectToRedis("testKey", "Hello, Redis!");

        // 获取数据
        String value = redisUtil.getObjectFromRedis("testKey", String.class);
        System.out.println("Value: " + value);
    }


    @ApiOperation(value = "测试客户端连接情况")
    @GetMapping("/t2")
    public void t2() {
        RedisDemo redisDemo = new RedisDemo();
        redisDemo.setName("18");
        redisDemo.setAge("小明");

        redisUtil.setObjectToRedis("login-user", redisDemo);

        RedisDemo redisDemo1 = redisUtil.getObjectFromRedis("login-user", RedisDemo.class);

        // 获取数据
        System.out.println("Value: " + redisDemo1.toString());
    }
}
