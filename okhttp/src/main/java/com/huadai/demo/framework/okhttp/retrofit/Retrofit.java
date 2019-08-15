package com.huadai.demo.framework.okhttp.retrofit;

import android.print.PrintJob;

import java.lang.annotation.Retention;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.FloatBuffer;
import java.util.Map;

import okhttp3.Call;
import okhttp3.OkHttpClient;

/**
 * Created by 花歹 on 2019/7/17.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class Retrofit {

    public final String baseUrl;
    public final Call.Factory callFactory;
    private Map<Method, ServiceMethod> ServiceMethodCache;

    public Retrofit(Builder builder){
        this.baseUrl = builder.baseUrl;
        this.callFactory = builder.callFactory;
    }

    public <T> T create(Class<T> service){
        // 校验，是不是个接口，不能让他继承子接口。



        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //是不是Object的方法 （比如调用toString方法）
                if(method.getDeclaringClass() == Object.class){
                    return method.invoke(this,args);
                }
                //解析参数注解
                ServiceMethod serviceMethod = loadServiceMethod(method);

                // 封装okhttpCall
                OkHttpCall okHttpCall = new OkHttpCall(serviceMethod,args);

                return okHttpCall;
            }
        });
    }

    private ServiceMethod loadServiceMethod(Method method) {
        //享元
        ServiceMethod serviceMethod = ServiceMethodCache.get(method);
        if(serviceMethod == null){
            serviceMethod = new ServiceMethod.Builder(this,method).build();
            ServiceMethodCache.put(method,serviceMethod);
        }
        return null;
    }


    public static class Builder{

        public Call.Factory callFactory;
        String baseUrl;
        public Builder baseUrl(String baseUrl){
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder client(Call.Factory client){
            return this;
        }

        public Retrofit build(){
            return new Retrofit(this);
        }
    }
}
