package com.df;

import com.df.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author feng.dai
 * @Date 2023/5/25 15:00
 * @Project_Name api-bankend
 * @Package_Name com.df
 */
@SpringBootTest
public class RedisDemo {


    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void save() {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");
        list.add("000");
        redisUtil.set("key4",list);
    }

    @Test
    public void get(){
        System.out.println(redisUtil.get("key3"));
    }
}
