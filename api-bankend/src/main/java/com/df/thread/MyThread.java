package com.df.thread;

/**
 * @Author feng.dai
 * @Date 2023/4/25 11:05
 * @Project_Name mybatisPlus
 * @Package_Name com.df.thread.typeOne
 */
public class MyThread extends Thread{
    @Override
    public void run (){
        System.out.println("继承Thread，重写run");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
