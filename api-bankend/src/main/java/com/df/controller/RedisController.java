package com.df.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.df.mapper.mysql.UserMapper;
import com.df.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    private UserMapper userMapper;

    public RedisController(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/save")
    public void save(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @PostMapping("/del")
    public Boolean del(String key) {
        Boolean b = redisTemplate.delete(key);
        return b;
    }

    @GetMapping("/push")
    public Long push() {
        List<User> list = userMapper.selectList(new QueryWrapper<User>());
        Long count = redisTemplate.opsForList().leftPushAll("userList", list);
        return count;
    }
}
