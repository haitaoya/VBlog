package com.iain.blog.listener;

import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Classname ListenerMains
 * @Description TODO
 * @Date 2021/10/14 下午8:31
 * @Created by wht
 */
@Component
public class ListenerMains {
    //@Async  // 开启异步就无法使用@Order(0)进行排序了
    @SneakyThrows
    @Order(0)
    @Async
    @EventListener(Mains.class)
    public void listener(Mains mains){
        System.out.println(Thread.currentThread().getName() +"-1");
        TimeUnit.SECONDS.sleep(5);

        System.out.println("这是第一个监听类 "+mains.getSource());
    }


    @Order(1)
    @EventListener(Mains.class)
    public void listener2(Mains mains){
        System.out.println(Thread.currentThread().getName() +"2");
        System.out.println("这是第二个监听类 "+mains.getSource());
    }

    //@Async
    @Order(2)
    @EventListener(Mains.class)
    public void listener3(Mains mains){
        System.out.println("这是第三个监听类 "+mains.getSource());
    }

}
