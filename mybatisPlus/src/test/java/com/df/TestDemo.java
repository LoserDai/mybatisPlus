package com.df;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.df.mapper.UserMapper;
import com.df.model.entity.User;
import com.df.model.enums.ReportStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author feng.dai
 * @Date 2023/3/2 12:31
 * @Project_Name mybatisPlus
 * @Package_Name com.df
 */
@SpringBootTest
public class TestDemo {

    static List<Integer> orderList = new ArrayList<>();
    static List<Integer> randomList = new ArrayList<>();
    static {
        orderList.add(7);
        orderList.add(8);
        orderList.add(9);
        orderList.add(4);
        orderList.add(5);
        orderList.add(6);
        orderList.add(1);
        orderList.add(2);
        orderList.add(3);

        randomList.add(1);
        randomList.add(4);
        randomList.add(7);
        randomList.add(2);
        randomList.add(5);
        randomList.add(8);
        randomList.add(3);
        randomList.add(6);
        randomList.add(9);
    }

    @Autowired
    private UserMapper userMapper;

    /**
     * stream流根据已知list排序
     */
    @Test
    public void testSort(){
        List<Integer> collect = randomList.stream().sorted((e1, e2) -> {
            Integer orderIndex1 = orderList.indexOf(e1);
            Integer orderIndex2 = orderList.indexOf(e2);
            return orderIndex1 - orderIndex2;
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * stream流根据条件分组查询
     */
    @Test
    public void testGroupBy(){
        List<User> list = userMapper.selectList(new QueryWrapper<User>().lambda().ge(User::getAge, 23));
        Map<Integer, List<User>> collect = list.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(collect);
        System.out.println(collect.size());
    }

    /**
     * 分页查询
     */
    @Test
    public void getPageTest(){

        Page<User> page = new Page<>(1, 4);

        Page<User> userPage = userMapper.selectPage(page, new QueryWrapper<User>().lambda().ge(User::getAge, 5));
        System.out.println("=======展示结果=======");
        userPage.getRecords().forEach(System.out::println);
    }

    /**
     * 根据条件查询
     */
    @Test
    public void getByQuery() {
        List<User> userList = userMapper.selectList(new QueryWrapper<User>()
                .lambda()
                .ge(User::getAge, 18));
        System.out.println("=======展示结果=======");
        userList.forEach(System.out::println);
    }

    /**
     * 根据条件删除
     */
    @Test
    public void delete(){
        int i = userMapper.delete(new QueryWrapper<User>()
                .lambda()
                .le(User::getAge, 19));
    }

    /**
     * 枚举类测试获取数据
     */
    @Test
    public void getEnum(){
        int value = ReportStatusEnum.DEFAULT.getValue();
        //0
        System.out.println(value);
        //获取枚举类中的values列表
        List<Integer> list = ReportStatusEnum.getValues();
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void getValue2(){
        List<String> list = new ArrayList<>();
        list.add("spring");
        list.add("spring");
        list.add("spring");
        list.add("summer");
        list.add("autumn");
        list.add("autumn");
        list.add("winter");
        list.stream().distinct().forEach(System.out::println);

    }
}
