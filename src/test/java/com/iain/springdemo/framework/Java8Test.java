package com.iain.springdemo.framework;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname Java8Test
 * @Description TODO
 * @Date 2021/1/6 下午9:55
 * @Created by wht
 */
public class Java8Test {
    @Test
    public void testStreamCollect(){
        ArrayList<String>  arrayList = new ArrayList<String>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        ArrayList<String>  arrayList1 = new ArrayList<String>();
        arrayList1.add("ccc");
        arrayList1.add("ddd");
//        ArrayList<String> arrayListMerge = new ArrayList<String>();
        arrayList1 = (ArrayList<String>) arrayList.stream().collect(Collectors.toList());
        System.out.println("");
        List list = strArr2List("", "", "");

//        Collector
    }

    public List strArr2List(String... str){
        return toList(str);
    }
    public List toList(String[] str){
        return Arrays.asList(str);
    }

    @Test
    public void testException(){
        int a ;
        new RuntimeException();
        System.out.println("new e");
    }

    @Test
    public void testCalendar(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
             date = format.parse("2021-12-31");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date time0 = calendar.getTime();
        System.out.println(time0);
        calendar.add(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date time1 = calendar.getTime();
        System.out.println(time1);

        calendar.set(Calendar.DAY_OF_MONTH,1);
        Date time2 = calendar.getTime();
        System.out.println(time2);

        Date time = calendar.getTime();
        System.out.println(time);
    }

    @Test
    public void testCalendar1(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse("2021-03-31");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
//        calendar.add(Calendar.MONTH,-1);
//        Date time00 = calendar.getTime();
//        System.out.println(time00);
//        try {
//            date = format.parse("2021-03-31");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        calendar.clear();
//        calendar.setTime(date);
        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH) -1);
        Date time0 = calendar.getTime();
        System.out.println(time0);
        calendar.add(Calendar.MONTH,-1);
        Date time1 = calendar.getTime();
        System.out.println(time1);

        calendar.set(Calendar.DAY_OF_MONTH,1);
        Date time2 = calendar.getTime();
        System.out.println(time2);

        Date time = calendar.getTime();
        System.out.println(time);
    }

    @Test
    public void testCalendar11(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        String sss = (String)objectObjectHashMap.get("sss");
        System.out.println(sss);
    }
}
