package com.demo.genericityframework;

/**
 * Created by 花歹 on 2018/3/13.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class ArrayList<T> {
    private T[] items ;

    public void add(T t) {
        items[0] = t;
    }

    public <E> void add2(E e){

    }


}
