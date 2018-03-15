package com.demo.genericityframework;

/**
 * Created by 花歹 on 2018/3/13.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public abstract class HttpCallback<T> {

    public abstract void onSuccess(T result);
}
