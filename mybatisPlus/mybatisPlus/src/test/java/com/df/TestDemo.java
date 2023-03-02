package com.df;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.df.mapper.UserMapper;
import com.df.pojo.User;
import org.apache.ibatis.javassist.compiler.ast.Variable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author feng.dai
 * @Date 2023/3/2 12:31
 * @Project_Name mybatisPlus
 * @Package_Name com.df
 */
@SpringBootTest
public class TestDemo {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getPageTest(){

        Page<User> page = new Page<>(1, 4);

        Page<User> userPage = userMapper.selectPage(page, new QueryWrapper<User>().lambda().ge(User::getAge, 5));
        System.out.println("=======展示结果=======");
        userPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void getByQuery() {
        List<User> userList = userMapper.selectList(new QueryWrapper<User>()
                .lambda()
                .ge(User::getAge, 18));
        System.out.println("=======展示结果=======");
        userList.forEach(System.out::println);
    }
}
