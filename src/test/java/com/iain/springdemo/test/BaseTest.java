package com.iain.blog.test;


import com.iain.blog.domain.PdtInfo;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname BaseTest
 * @Description 测试类基类
 * @Date 2020/8/16 4:10 下午
 * @Created by wht
 */
public class BaseTest {

    @Test
    public  void cloneTest() throws CloneNotSupportedException {
        PdtInfo pdtInfo = new PdtInfo();
        PdtInfo pdtInfoCp = new PdtInfo();
        pdtInfoCp=pdtInfo;
        pdtInfo.setCrtTm(new Date());
        PdtInfo clone = pdtInfo.clone();
        System.out.println(clone.equals(pdtInfo));
        System.out.println(clone==pdtInfo);
        System.out.println(clone.getClass()==pdtInfo.getClass());
    }
    @Test
    public void timeTest(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
    }
    @Test
    public void repeatedSubstringPattern() {
        String s ="abcabc";
        Boolean subs = (s+s).substring(1,s.length()*2-1).contains(s);
        System.out.println(subs);
    }
}
