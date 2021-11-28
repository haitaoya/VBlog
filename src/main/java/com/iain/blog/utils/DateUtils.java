package com.iain.blog.utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @Classname DateUtils
 * @Description TODO
 * @Date 2021/10/19 上午11:10
 * @Created by wht
 */
public final class DateUtils {
    public static void calculateTimeDifferenceByPeriod(int year, Month month, int dayOfMonth) {
        LocalDate today = LocalDate.now();
        System.out.println("Today：" + today);
        LocalDate oldDate = LocalDate.of(year, month, dayOfMonth);
        System.out.println("OldDate：" + oldDate);

        Period p = Period.between(oldDate, today);
        System.out.printf("目标日期距离今天的时间差：%d 年 %d 个月 %d 天\n", p.getYears(), p.getMonths(), p.getDays());
    }

    public static void main(String[] args) {
//        calculateTimeDifferenceByPeriod(2020, Month.OCTOBER, 20);
        calculateTimeDifferenceByChronoUnit();
    }

    public static void calculateTimeDifferenceByChronoUnit() {
        LocalDate startDate = LocalDate.of(2019, Month.OCTOBER, 9);
        System.out.println("开始时间：" + startDate);

        LocalDate endDate = LocalDate.of(2020, Month.OCTOBER, 9);
        System.out.println("结束时间：" + endDate);

        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("两个时间之间的天数差为：" + daysDiff);

        long monthDiff = ChronoUnit.MONTHS.between(startDate, endDate);
        System.out.println("两个时间之间的月份差为：" + monthDiff);
//  long hoursDiff = ChronoUnit.HOURS.between(startDate, endDate);  //这句会抛出异常，因为LocalDate表示的时间中不包含时分秒等信息
    }
}
