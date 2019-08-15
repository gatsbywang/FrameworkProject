package com.huadai.demo.framework.okhttp.retrofit;

import com.huadai.demo.framework.okhttp.RequestBuilder;

/**
 * Created by 花歹 on 2019/7/19.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public interface ParameterHandler<T> {

    public void apply(RequestBuilder requestBuilder,T value);

    //Query,Part,QueryMap,Field等等
    class Query<T> implements ParameterHandler<T>{

        private final String key;//保存 就是参数的key值 （比如userName,password）

        public Query(String key){
            this.key =key;
        }



        @Override
        public void apply(RequestBuilder requestBuilder, T value) {
            requestBuilder.addQueryName(key,value.toString());
        }
    }
}
