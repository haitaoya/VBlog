package com.iain.blog.event;

import java.util.EventListener;

/**
 * @Classname StateListener
 * @Description TODO
 * @Date 2021/10/14 下午7:40
 * @Created by wht
 */
public interface StateListener extends EventListener {
    void handleState(StateEvent event);
}