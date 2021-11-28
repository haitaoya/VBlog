package com.iain.blog.event;

/**
 * @Classname ListenerTest
 * @Description TODO
 * @Date 2021/10/14 下午7:43
 * @Created by wht
 */
public class ListenerTest {

    public static void main(String[] args) {
        StateManager manager = new StateManager();
        manager.addListener(new WakeListener());
        manager.addListener(new SleepListener());
        manager.wake();
        System.out.println("-----------------");
        manager.sleep();
    }
}
