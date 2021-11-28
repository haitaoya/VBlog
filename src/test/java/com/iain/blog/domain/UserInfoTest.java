package com.iain.blog.domain;

import org.junit.Test;

public class UserInfoTest {
    @Test
    public void testHashCode(){
        UserInfo userInfo = new UserInfo();
        int i = userInfo.hashCode();
        System.out.println(i);
        UserInfo userInfo2 = new UserInfo();
        int k = userInfo2.hashCode();
        System.out.println(k);
        UserInfo userInfo1= new UserInfo();
        userInfo1.setCrtUsr("2");
        int j = userInfo1.hashCode();
        System.out.println(j);
        boolean equals = userInfo1.equals(userInfo2);
        System.out.println(equals);


        System.out.println(Integer.toBinaryString((9 ^ 7) >>> 0));
        //位运算符    & 按位与 |或  ^异或  ~非
        System.out.println(Integer.toBinaryString(~ 0b1001));
    }
}
