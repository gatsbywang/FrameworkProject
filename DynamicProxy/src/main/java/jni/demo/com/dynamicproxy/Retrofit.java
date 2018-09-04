package jni.demo.com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 花歹 on 2018/7/10.
 * Email:   gatsbywang@126.com
 * Description: retrofit create
 * Thought:
 */

public class Retrofit {


    public <T> T create(Class<T> clazz) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //

                //返回的对象 应该是Call<T>
                return null;
            }
        });
    }
}
