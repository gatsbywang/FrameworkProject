package com.demo.iterator.simple2;

/**
 * Created by 花歹 on 2018/9/5.
 * Email:   gatsbywang@126.com
 * Description: 迭代器接口
 * Thought:
 */

public interface Iterator<T> {

    T next();

    boolean hasNext();
}
