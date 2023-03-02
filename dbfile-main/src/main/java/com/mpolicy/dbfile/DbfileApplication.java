package com.mpolicy.dbfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableConfigurationProperties({MyProperties.class})
@EnableTransactionManagement
@SpringBootApplication
public class DbfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbfileApplication.class, args);
    }

}

