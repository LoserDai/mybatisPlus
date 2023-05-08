package com.df.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author feng.dai
 * @Date 2023/4/25 11:23
 * @Project_Name mybatisPlus
 * @Package_Name com.df.thread
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(new Runnable() {
            @Override
            public void run() {
                //执行业务逻辑
                for (int i = 1; i <= 1000; i++) {
                    System.out.println("111");
                    System.out.println("线程: " + Thread.currentThread().getName() + "执行了, " + i);
                }
            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                //执行业务逻辑
                for (int i = 1001; i <= 2000; i++) {
                    System.out.println("线程: " + Thread.currentThread().getName() + "执行了, " + i);
                }
            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                //执行业务逻辑
                for (int i = 2001; i <= 3000; i++) {
                    System.out.println("线程: " + Thread.currentThread().getName() + "执行了, " + i);
                }
            }
        });
    }
}
