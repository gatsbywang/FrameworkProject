package com.huadai.demo.framework.okhttp;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by 花歹 on 2019/6/16.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        Response response = chain.proceed(request);
        //过期时间是30s
        response.newBuilder().removeHeader("Cache-Control").removeHeader("Pragma").addHeader("Cache-Control","max-age="+30).build();
        return response;
    }
}
