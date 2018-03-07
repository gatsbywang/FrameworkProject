package com.demo.httpframework.simple5;

import android.content.Context;

import java.util.Map;

/**
 * Created by 花歹 on 2018/2/27.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public interface IHttpRequest {
    <T> void get(Context context, String url, Map<String, Object> params,
                 final HttpCallBack<T> callback, final boolean cache);

    <T> void post(Context context, String url, Map<String, Object> params,
                  final HttpCallBack<T> callback, final boolean cache);

    <T> void download(Context context, String url, Map<String, Object> params,
                  final HttpCallBack<T> callback);

    <T> void upload(Context context, String url, Map<String, Object> params,
                      final HttpCallBack<T> callback);
}
