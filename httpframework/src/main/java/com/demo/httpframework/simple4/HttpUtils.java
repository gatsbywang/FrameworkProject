package com.demo.httpframework.simple4;

import android.content.Context;

import com.demo.httpframework.OKHttpRequest;
import com.demo.httpframework.simple3.HttpCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 花歹 on 2018/2/27.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class HttpUtils {
    private final Context mContext;
    private OKHttpRequest mHttpRequest;

    private final int TYPE_POST = 0X0011, TYPE_GET = 0X0012;

    private int mType = TYPE_GET;

    private Map<String, Object> mParams;
    private String mUrl;

    private HttpUtils(Context context) {
        mHttpRequest = new OKHttpRequest();
        mParams = new HashMap<>();
        mContext = context;
    }

    public static HttpUtils with(Context context) {
        return new HttpUtils(context);
    }

    public HttpUtils get() {
        mType = TYPE_GET;
        return this;
    }

    public HttpUtils param(String key, Object value) {
        mParams.put(key, value);
        return this;
    }

    public HttpUtils url(String url) {
        mUrl = url;
        return this;
    }

    public HttpUtils cache(boolean cache) {
        return this;
    }

    public <T> void request() {
        request(null);
    }

    public <T> void request(final HttpCallBack<T> callback) {
        mHttpRequest.get(mContext, mUrl, mParams, callback, true);
    }


//    public <T> void get(Context context, String url, Map<String, Object> params,
//                        final HttpCallBack<T> callback, final boolean cache) {
//        mHttpRequest.get(context, url, params, callback, cache);
//    }
//
//
//    public <T> void get(Context context, String url, Map<String, Object> params,
//                        final HttpCallBack<T> callback, final boolean cache, final boolean cookie, int recount) {
//        mHttpRequest.get(context, url, params, callback, cache);
//    }


}
