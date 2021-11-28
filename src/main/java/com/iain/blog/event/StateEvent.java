package com.iain.blog.event;

import java.util.EventObject;

/**
 * @Classname listener
 * @Description TODO
 * @Date 2021/10/14 下午7:38
 * @Created by wht
 */
public class StateEvent extends EventObject {

    private static final long serialVersionUID = 5323292975415079206L;

    private Enum<ActionEnum> action;

    public StateEvent(Object source, Enum<ActionEnum> action) {
        super(source);
        this.action = action;
    }


    public Enum<ActionEnum> getAction() {
        return action;
    }


    public void setAction(Enum<ActionEnum> action) {
        this.action = action;
    }

}
