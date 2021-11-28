package com.iain.blog.event;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @Classname WakeListener
 * @Description TODO
 * @Date 2021/10/14 下午7:41
 * @Created by wht
 */
public class WakeListener implements StateListener {

    @SneakyThrows
    @Override
    public void handleState(StateEvent event) {
        if (event.getAction() != null && event.getAction().equals(ActionEnum.wake)) {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() +"你醒了。");
        }
    }
}
