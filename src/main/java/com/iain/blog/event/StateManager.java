package com.iain.blog.event;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname StateManager
 * @Description TODO
 * @Date 2021/10/14 下午7:42
 * @Created by wht
 */
public class StateManager {
    private List<StateListener> list = new ArrayList<StateListener>();

    public boolean addListener(StateListener listener){
        if(listener == null)
            return false;
        return list.add(listener);
    }

    public boolean removeListener(StateListener listener){
        if(listener == null)
            return false;
        return list.remove(listener);
    }

    private void notifyAllListeners(StateEvent event){
        for(StateListener listener : list){
            listener.handleState(event);
        }
    }

    public void wake(){
        StateEvent event = new StateEvent(this, ActionEnum.wake);
        notifyAllListeners(event);
    }

    public void sleep(){
        StateEvent event = new StateEvent(this, ActionEnum.sleep);
        notifyAllListeners(event);
    }

}

