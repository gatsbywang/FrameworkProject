package com.demp.framework.mvp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

/**
 * Created by 花歹 on 2019/7/30.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class BasePresenter<V extends BaseView,M extends BaseModel> {

    private V mView,mProxyView;


    private M mModel;

    public void attach(V view){
        this.mView = view;
        //用代理对象
       mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), new Class[]{view.getClass()}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //执行这个方法，调用的是被代理对象

                if(mView == null){
                    return null;
                }
                return method.invoke(mView,args);
            }
        });

       //创建Model 动态创建？获取Class 通过反射
        Type genType = this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) genType).getActualTypeArguments();
        try {
            mModel = (M) ((Class)actualTypeArguments[1]).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void detach(){
        this.mView = null;
    }

    public V getView(){
        return mProxyView;
    }

    public M getModel() {
        return mModel;
    }
}
