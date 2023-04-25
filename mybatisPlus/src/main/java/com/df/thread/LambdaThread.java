package com.df.thread;

/**
 * @Author feng.dai
 * @Date 2023/4/25 11:16
 * @Project_Name mybatisPlus
 * @Package_Name com.df.thread.typeFour
 */
public class LambdaThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("lambda创建");
        });
        thread.start();
    }
}
