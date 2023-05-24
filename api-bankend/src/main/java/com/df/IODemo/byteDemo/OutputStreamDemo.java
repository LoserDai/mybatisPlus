package com.df.IODemo.byteDemo;

import java.io.*;
import java.util.Objects;

/**
 * @Author feng.dai
 * @Date 2023/4/25 14:56
 * @Project_Name mybatisPlus
 * @Package_Name com.df.IODemo.byteDemo
 */
public class OutputStreamDemo {

    public static void main(String[] args) throws IOException {

        File src = new File("D:\\Files\\Demo\\");
        File targetDir = new File("D:\\");
        //拷贝
        //copyFile(src, targetDir);
        //递归拷贝
        copyDir(src,targetDir);
    }

    /**
     * 将源文件拷贝到目标文件
     * @param src 源文件
     * @param targetDir  目标文件
     */
    public static void copyFile(File src ,File targetDir) throws IOException {
        //拷贝Demo
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            File file = new File(targetDir, src.getName());
            os = new FileOutputStream(file);
            byte[] bytes = new byte[1024 * 1024];
            int len = 0;
            System.out.println("start copy...");
            while ((len = is.read(bytes)) != -1){
                //输出
                os.write(bytes,0,len);
            }
            System.out.println("copy over!");
        } catch (Exception e) {
            System.out.println("MSG：" + e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 递归拷贝目录文件
     */
    public static void copyDir(File srcDir , File targetDir) throws IOException {
        targetDir = new File(targetDir,srcDir.getName());
        if (!targetDir.exists()){
            targetDir.mkdirs();
        }
        File[] files = srcDir.listFiles();
        if (Objects.nonNull(files)){
            for (File file : files) {
                if (file.isDirectory()){
                    //递归拷贝目录
                    copyDir(file, targetDir);
                }else {
                    //执行文件拷贝
                    copyFile(file,targetDir);
                }
            }
        }
    }
}
