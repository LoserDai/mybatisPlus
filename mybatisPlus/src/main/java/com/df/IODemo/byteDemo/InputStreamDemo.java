package com.df.IODemo.byteDemo;

import java.io.*;

/**
 * @Author feng.dai
 * @Date 2023/4/25 14:37
 * @Project_Name mybatisPlus
 * @Package_Name com.df.IODemo.byteDemo
 */


public class InputStreamDemo {
    /**
     * 字节流：InputStream OutputStream
     * 字符流：Reader Writer
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
