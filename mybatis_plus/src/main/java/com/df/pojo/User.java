package com.df.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author feng.dai
 * @Date 2022/10/25 14:48
 * @Project_Name mybatis_plus
 * @Package_Name com.df.pojo
 */
@Data
@AllArgsConstructor //有参构造器
@NoArgsConstructor //无参构造
public class User {
    private Long id;
    private String name;
    private int age;
    private String email;
}
