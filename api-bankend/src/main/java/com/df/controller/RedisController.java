package com.df.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author feng.dai
 * @Date 2023/5/25 14:56
 * @Project_Name api-bankend
 * @Package_Name com.df.controller
 */

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final RedisTemplate redisTemplate;

    public RedisController(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/save")
    public void save(String key ,String value){
        redisTemplate.opsForValue().set(key,value);
    }
}
