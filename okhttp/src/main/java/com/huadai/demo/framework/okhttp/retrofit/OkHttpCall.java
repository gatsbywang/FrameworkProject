package com.huadai.demo.framework.okhttp.retrofit;


import android.util.Log;

import java.io.IOException;


/**
 * Created by 花歹 on 2019/7/19.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class OkHttpCall<T> implements Call<T> {

    final ServiceMethod serviceMethod;
    final Object[] args;

    public OkHttpCall(ServiceMethod serviceMethod, Object[] args) {
        this.serviceMethod = serviceMethod;
        this.args =args;
    }

    @Override
    public void enqueue(final Callback<T> callback) {
        //发起一个请求，给一个回调
       okhttp3.Call call = serviceMethod.createNewCall(args);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                if(callback != null){
                    callback.onFailure(OkHttpCall.this,e);
                }
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                // 解析 Response -> Response<T> 回调
                Log.e("TAG",response.body().string());
                Response rResponse = new Response();
                rResponse.body = serviceMethod.parseBody(response.body());
            }
        });
    }
}
