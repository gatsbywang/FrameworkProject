package com.huadai.demo.framework.okhttp;

import com.huadai.demo.framework.okhttp.retrofit.ParameterHandler;

import okhttp3.HttpUrl;
import okhttp3.Request;

/**
 * Created by 花歹 on 2019/7/21.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class RequestBuilder {
    ParameterHandler<Object>[] parameterHandlers;
    Object[] args;
    HttpUrl httpUrl;

    public RequestBuilder(String baseUrl, String relativeUrl, String httpMethod, ParameterHandler<?>[] parameterHandlers, Object[] args) {
        this.parameterHandlers = (ParameterHandler<Object>[])parameterHandlers;
        this.args =args;
        this.httpUrl = HttpUrl.parse(baseUrl+relativeUrl);
    }

    public Request build(){

        int count = args.length;
        for (int i=0;i<count;i++) {

            parameterHandlers[i].apply(this,args[i]);
        }

        Request request = new Request.Builder().url(httpUrl).build();
        return request;
    }

    public void addQueryName(String key, String value) {
        //userName = Darren&password = value
        httpUrl =   httpUrl.newBuilder().addQueryParameter(key,value).build();

    }
}
