package com.demo.framework.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 花歹 on 2018/6/4.
 * Email:   gatsbywang@126.com
 * Description: 被观察者
 * Thought:
 */

public class Observable<M, T extends Observer<M>> {

    private List<T> observers;

    public Observable() {
        observers = new ArrayList<>();
    }

    public void register(T observer) {
        observers.add(observer);
    }

    public void unRegister(T observer) {
        observers.remove(observer);
    }

    public void addUpdater(M m) {
        for (T observer : observers) {
            observer.update(m);
        }

    }
}


