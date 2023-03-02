package com.df;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author feng.dai
 * @Date 2023/3/2 12:23
 * @Project_Name mybatisPlus
 * @Package_Name com.df
 */
@SpringBootApplication
@MapperScan("com.df.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
