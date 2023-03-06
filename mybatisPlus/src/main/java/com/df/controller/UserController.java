package com.df.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.df.mapper.UserMapper;
import com.df.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 根据id查询
     * @param id
     * @return
     */
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

    /**
     * 根据年龄分页查询
     * @param age
     * @return
     */
    @RequestMapping("/getPageUser/{age}")
    public @ResponseBody List<User> getPageUser(@PathVariable Integer age){
        //默认是一页10条数据
        Page<User> page = new Page<>();
        Page<User> userPage = userMapper.selectPage(page, new QueryWrapper<User>().lambda().le(User::getAge, age));
        List<User> list = userPage.getRecords();
        return list;
    }
}
