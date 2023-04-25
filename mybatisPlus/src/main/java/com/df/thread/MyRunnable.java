package com.df.thread;


/**
 * @Author feng.dai
 * @Date 2023/4/25 11:08
 * @Project_Name mybatisPlus
 * @Package_Name com.df.thread.typeTwo
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("实现Runnable接口，重写run方法");
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
