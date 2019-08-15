package com.huadai.demo.framework.okhttp.retrofit;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 花歹 on 2019/7/14.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public abstract class HttpCallback<T> implements Callback<Result<T>> {


    @Override
    public void onResponse(Call<Result<T>> call, Response<Result<T>> response) {
        Result<T> result = response.body();
        if(!result.isOK()){
            onError(result.code,result.msg);
        }

        //先拿到泛型
        Class<T> dataClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Gson gson = new Gson();
        T data = gson.fromJson(result.data.toString(), dataClass);
        onSucceed(data);
    }

    @Override
    public void onFailure(Call<Result<T>> call, Throwable t) {
        //处理失败，联网，解析出错

    }

    public abstract void onSucceed(T result);

    public abstract void onError(String code,String msg);
}
