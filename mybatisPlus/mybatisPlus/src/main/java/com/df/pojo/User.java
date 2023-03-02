package com.df.pojo;

/**
 * @Author feng.dai
 * @Date 2023/3/2 12:24
 * @Project_Name mybatisPlus
 * @Package_Name com.df.pojo
 */
import lombok.Data;
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
