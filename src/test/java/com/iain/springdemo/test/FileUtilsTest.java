package com.iain.springdemo.test;

import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;

/**
 * @Classname FileUtilsTest
 * @Description TODO
 * @Date 2021/9/7 下午1:49
 * @Created by wht
 */
public class FileUtilsTest {
    @SneakyThrows
    public static void main(String[] args) {
        boolean directory = new File("./tmp/aaa.a").exists();
        boolean directory1 = new File("./tmp/aaa.aa").exists();
        boolean directory2 = new File("./tmp/aaaaa").exists();
        System.out.println(directory);
        System.out.println(directory1);
        System.out.println(directory2);
//        FileUtils.forceMkdir(new File("./tmp/aaa.aa"));
    }
}
