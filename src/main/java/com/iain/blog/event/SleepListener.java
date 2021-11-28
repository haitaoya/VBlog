package com.iain.blog.event;

/**
 * @Classname SleepListener
 * @Description TODO
 * @Date 2021/10/14 下午7:42
 * @Created by wht
 */
public class SleepListener implements StateListener {

    @Override
    public void handleState(StateEvent event) {
        if(event.getAction() != null && event.getAction().equals(ActionEnum.sleep)){
            System.out.println(Thread.currentThread().getName() +"你睡了！");
        }
    }

}

