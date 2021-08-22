package com.iain.blog.utils;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Classname CommonRateLimiterManager
 * @Description 限流器，令牌桶
 * @Date 2021/7/21 下午5:51
 * @Created by wht
 */
public class CommonRateLimiterManager {
    private RateLimiter rateLimiter;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    CommonRateLimiterManager(){
        rateLimiter = RateLimiter.create(5);//桶大小为5,每秒5次请求，就是每200ms放一个令牌到桶中，
    }
    public void tryAcquire(int count){
        if(rateLimiter.tryAcquire(count)){//非阻塞式，无参数时，默认取1个令牌，超时时间0s，拿不到瞬间失败。
            System.out.println("获取令牌成功，获取令牌数"+count);
        }else {
            System.out.println("获取令牌失败");
        }
    }
    public void tryAcquireWithTimeOut(int count){
        if(rateLimiter.tryAcquire(count,1000, TimeUnit.MILLISECONDS)){//非阻塞式，有参数时，获取制定数量的令牌.后边的参数是最长等待时间。
            System.out.println("获取令牌成功，获取令牌数"+count);
        }else {
            System.out.println("获取令牌失败");
        }
    }
    public void acquire(int count){
        double acquire = rateLimiter.acquire(count);//阻塞式
        System.out.println("阻塞时间"+acquire);
    }
    public static void main(String[] args) throws InterruptedException {
        CommonRateLimiterManager commonRateLimiterManager = new CommonRateLimiterManager();
        commonRateLimiterManager.test1(commonRateLimiterManager);

        commonRateLimiterManager.test2(commonRateLimiterManager);

        commonRateLimiterManager.test3(commonRateLimiterManager);
    }
    //非阻塞式，不设置等待时间，需自行控制获取间隔
    public void test1(CommonRateLimiterManager commonRateLimiterManager) throws InterruptedException {
        System.out.println("非阻塞式测试开始时间"+SDF.format(new Date()));
        commonRateLimiterManager.tryAcquire(1);
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("时间"+SDF.format(new Date()));
        commonRateLimiterManager.tryAcquire(5);
        TimeUnit.MILLISECONDS.sleep(1000);//支持预消费
        System.out.println("时间"+SDF.format(new Date()));
        commonRateLimiterManager.tryAcquire(1);
        System.out.println("时间"+SDF.format(new Date()));
        commonRateLimiterManager.tryAcquire(1);
        System.out.println("时间"+SDF.format(new Date()));
    }
    //非阻塞式，设置等待时间，自动把控时间间隔
    public void test2(CommonRateLimiterManager commonRateLimiterManager) throws InterruptedException {
        System.out.println("非阻塞式测试开始时间"+SDF.format(new Date()));
        commonRateLimiterManager.tryAcquireWithTimeOut(1);
        System.out.println("时间"+SDF.format(new Date()));
        commonRateLimiterManager.tryAcquireWithTimeOut(5);//支持预消费
        System.out.println("时间"+SDF.format(new Date()));
        commonRateLimiterManager.tryAcquireWithTimeOut(1);
        System.out.println("时间"+SDF.format(new Date()));
        commonRateLimiterManager.tryAcquireWithTimeOut(1);
        System.out.println("时间"+SDF.format(new Date()));
    }
    //阻塞式，一直等待
    public void test3(CommonRateLimiterManager commonRateLimiterManager) throws InterruptedException {
        System.out.println("阻塞式测试开始时间"+SDF.format(new Date()));
        commonRateLimiterManager.acquire(1);
        System.out.println("时间"+SDF.format(new Date()));
        commonRateLimiterManager.acquire(1);
        System.out.println("时间"+SDF.format(new Date()));
        commonRateLimiterManager.acquire(20);//支持预消费
        System.out.println("时间"+SDF.format(new Date()));
        commonRateLimiterManager.acquire(1);
        System.out.println("时间"+SDF.format(new Date()));
    }
}
