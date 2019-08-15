package com.huadai.demo.framework.okhttp;

import android.content.Context;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 花歹 on 2019/6/25.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class CacheRequestInterceptor implements Interceptor {

    private Context mContext ;

    public CacheRequestInterceptor(Context context){
        this.mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        if(isNetWork(mContext)){
            request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
        }

        return chain.proceed(request);
    }

    private boolean isNetWork(Context mContext) {
        return false;
    }
}
