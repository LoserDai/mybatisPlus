package com.df.IODemo.byteDemo;

import java.io.*;

/**
 * @Author feng.dai
 * @Date 2023/4/25 14:37
 * @Project_Name mybatisPlus
 * @Package_Name com.df.IODemo.byteDemo
 */

/**
 * 一般二进制类型的文件(图片，视频，音频，压缩文件等无法直接使用文本文档打开的文件)主要使用字节流操作
 * 一般文本类型文件(txt,md,java等可以直接使用文本文档打开的文件)主要使用字符流操作
 */
public class InputStreamDemo {
    /**
     * 字节流：InputStream OutputStream 处理图片视频等
     * 字符流：Reader Writer 处理java，txt，md等
     * @param args
     */
    public static void main(String[] args) {
        InputStream in = null;
        File file = null;
        try {
            file = new File("D:\\Files\\Demo.txt");
            in = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int leng = 0;
            while ((leng = in.read(bytes)) != -1){
                System.out.println(new String(bytes,0,leng));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}
