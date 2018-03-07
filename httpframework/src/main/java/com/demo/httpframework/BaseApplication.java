package com.demo.httpframework;

import android.app.Application;

import com.demo.httpframework.simple5.HttpUtils;

/**
 * Created by 花歹 on 2018/2/27.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        HttpUtils.initHttpRequest(new OKHttpRequest());
    }
}
