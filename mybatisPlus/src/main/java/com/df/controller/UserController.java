package com.df.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.df.mapper.UserMapper;
import com.df.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author feng.dai
 * @Date 2023/3/3 9:29
 * @Project_Name mybatisPlus
 * @Package_Name com.df.controller
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/getUser/{id}")
    public User getUserByQuery(@PathVariable("id") String id){

        List<User> list = userMapper.selectList(new QueryWrapper<User>()
                .lambda()
                .eq(User::getId, id));
        System.out.println(list);
        User user = list.get(0);
        if (user == null){
            return null;
        }
        return user;
    }
}
