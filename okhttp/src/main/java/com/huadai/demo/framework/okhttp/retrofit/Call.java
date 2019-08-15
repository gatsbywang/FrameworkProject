package com.huadai.demo.framework.okhttp.retrofit;

/**
 * Created by 花歹 on 2019/7/17.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public interface Call<T> {

    void enqueue(Callback<T> callback);

}
