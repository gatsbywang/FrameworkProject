package com.demo.framework.observer;

/**
 * Created by 花歹 on 2018/6/4.
 * Email:   gatsbywang@126.com
 * Description: 观察者
 * Thought:
 */

public interface Observer<T> {

    void update(T t);
}
