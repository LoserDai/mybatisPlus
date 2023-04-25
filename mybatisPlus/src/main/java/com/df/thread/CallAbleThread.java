package com.df.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author feng.dai
 * @Date 2023/4/25 11:18
 * @Project_Name mybatisPlus
 * @Package_Name com.df.thread.typeFive
 */
public class CallAbleThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("创建线程: " + Thread.currentThread().getName());
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new CallAbleThread());
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("创建线程: " + task.get());
    }
}
