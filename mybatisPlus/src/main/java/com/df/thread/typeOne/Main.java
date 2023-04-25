package com.df.thread.typeOne;

/**
 * @Author feng.dai
 * @Date 2023/4/25 11:12
 * @Project_Name mybatisPlus
 * @Package_Name com.df.thread.typeThree
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run(){
                System.out.println("使用匿名内部类创建");
            }
        };
        thread.start();
    }
}
