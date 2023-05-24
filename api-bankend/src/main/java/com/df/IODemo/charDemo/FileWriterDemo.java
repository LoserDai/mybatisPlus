package com.df.IODemo.charDemo;

import java.io.FileWriter;

/**
 * @Author feng.dai
 * @Date 2023/4/25 15:36
 * @Project_Name mybatisPlus
 * @Package_Name com.df.IODemo.charDemo
 */
public class FileWriterDemo {
    /**
     * 往目标文件中写入
     * @param args
     */
    public static void main(String[] args){
        try {
            FileWriter fw = new FileWriter("D:\\Files\\Demo\\Demo.txt");
            fw.write("作者：岳飞");
            fw.flush();
            Thread.sleep(1000);
            fw.write("good good study,day day up");
            fw.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
