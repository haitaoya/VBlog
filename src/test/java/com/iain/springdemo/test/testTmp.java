package com.iain.springdemo.test;

import com.iain.blog.domain.UserInfo;
import com.iain.blog.enumvo.Type;
import org.apache.catalina.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Classname testTmp
 * @Description TODO
 * @Date 2021/7/27 下午12:19
 * @Created by wht
 */
public class testTmp extends Thread {
    @Override
    public void run() {
        System.out.print("run ");

    }

    public static String camel2Underline(String line) {
        if (line == null || "".equals(line)) {
            return "";
        }
        line = String.valueOf(line.charAt(0)).toUpperCase()
                .concat(line.substring(1));
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String word = matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end() == line.length() ? "" : "_");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException {
//        String tSysLog = camel2Underline("TSysLog");
        ArrayList<UserInfo> userInfos = new ArrayList<>();

//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserNam("A");
//        userInfos.add(userInfo);
//        UserInfo userInfo1 = new UserInfo();
//        userInfo1.setUserNam("A");
//        userInfos.add(userInfo1);
//        Map<String, Boolean> collect = userInfos.stream().collect(Collectors.toMap(item -> item.getUserNam(), item -> true));
//        System.out.println(collect.toString());
//
//        StringBuilder stringBuilder = new StringBuilder();
//        System.out.println(stringBuilder);

//        String value = Type.A.getType();
//        String value1 = Type.B.getType();
//        System.out.println(value);
//        System.out.println(value1);
        UserInfo userInfo = new UserInfo();
        formatTest(userInfo);
        System.out.println(userInfo.getUserNam());

        BigDecimal bigDecimal1 = new BigDecimal(100);
        BigDecimal bigDecimal2 = new BigDecimal(200);
        BigDecimal divide = bigDecimal1.add(bigDecimal2).divide(new BigDecimal(2));
        System.out.println(divide);


    }

    static <T> T formatTest(T t) {
        UserInfo userInfo = (UserInfo) t;
        userInfo.setUserNam("2222");
        t = (T) userInfo;
        return t;
    }




}
