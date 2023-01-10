package com.df;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author feng.dai
 * @Date 2022/10/25 14:50
 * @Project_Name mybatis_plus
 * @Package_Name com.df
 */
@SpringBootApplication
@MapperScan("com.df.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
