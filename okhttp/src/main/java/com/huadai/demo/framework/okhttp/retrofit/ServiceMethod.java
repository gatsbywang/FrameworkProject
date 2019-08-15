package com.huadai.demo.framework.okhttp.retrofit;

import com.google.gson.Gson;
import com.huadai.demo.framework.okhttp.RequestBuilder;
import com.huadai.demo.framework.okhttp.retrofit.http.GET;
import com.huadai.demo.framework.okhttp.retrofit.http.POST;
import com.huadai.demo.framework.okhttp.retrofit.http.Query;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 * Created by 花歹 on 2019/7/17.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
class ServiceMethod {

    Retrofit retrofit;
    Method method;
    private String httpMethod;
    private String relativeUrl;


    final ParameterHandler<?>[] parameterHandlers;

    public ServiceMethod(Builder builder) {
        this.relativeUrl = builder.relativeUrl;
        this.retrofit = builder.retrofit;
        this.httpMethod = builder.httpMethod;
        this.method = builder.method;
        this.parameterHandlers = builder.parameterHandlers;
    }

    public okhttp3.Call createNewCall(Object[] args) {
        RequestBuilder requestBuilder = new RequestBuilder(retrofit.baseUrl,relativeUrl,httpMethod,parameterHandlers,args);

        //添加参数
        return retrofit.callFactory.newCall(requestBuilder.build());
    }

    public <T> T parseBody(ResponseBody responseBody) {
        // 获取解析的类型 T 获取方法返回值的类型

        Type type = method.getGenericReturnType();// 返回值对象的所有泛型
        Class<T> dataClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
        //解析工厂转换
        Gson gson  = new Gson();
        T body = gson.fromJson(responseBody.charStream(),dataClass);

        return body;
    }

    public static class Builder {
        private final Annotation[] methodAnnotations;
        private final Annotation[][] parameterAnnotations; //1维放参数，2维为参数中的注解
        Retrofit retrofit;
        Method method;
        private String httpMethod;
        private String relativeUrl;


        final ParameterHandler<?>[] parameterHandlers;

        public Builder(Retrofit retrofit, Method method) {
            this.retrofit =retrofit;
            this.method = method;
            this.methodAnnotations = method.getAnnotations();
            this.parameterAnnotations = method.getParameterAnnotations();
            parameterHandlers = new ParameterHandler[parameterAnnotations.length];
        }

        public ServiceMethod build() {
            //解析  okhttp请求时候， url = baseUrl + relativeUrl,method

            for (Annotation methodAnnotation : methodAnnotations) {
                parseAnnotationMethod(methodAnnotation);
            }


            //参数解析
            int count =parameterAnnotations.length;
            for (int i=0;i<count;i++) {
                Annotation parameter = parameterAnnotations[i][0];

                if(parameter instanceof Query){
                    //一个个封装成了ParameterHandler, 不同的参数
                    parameterHandlers[i] = new ParameterHandler.Query<>(((Query) parameter).value());
                }
            }
            return new ServiceMethod(this);
        }


        private void parseAnnotationMethod(Annotation methodAnnotation) {
            //value
            if(methodAnnotation  instanceof GET){
                parseMethodAndPath("GET",((GET)(methodAnnotation)).value());
            }else if(methodAnnotation  instanceof POST){
                parseMethodAndPath("POST",((POST)(methodAnnotation)).value());
            }
        }

        private void parseMethodAndPath(String method, String value) {
            this.httpMethod = method;
            this.relativeUrl = value;
        }
    }
}
