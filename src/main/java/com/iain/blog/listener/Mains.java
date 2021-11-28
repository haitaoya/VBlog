package com.iain.blog.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @Classname ListenerTest
 * @Description TODO
 * @Date 2021/10/14 下午8:28
 * @Created by wht
 */
public class Mains extends ApplicationEvent {

    public Mains(Object name) {
        super(name);

        System.out.println(String.format("Hi,我是被监听的%s！",name));
    }
}