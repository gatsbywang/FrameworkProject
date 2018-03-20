package com.demo.payframework;

import android.app.Application;

import com.demo.payannotations.WXPayEntry;

/**
 * Created by 花歹 on 2018/3/20.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

@WXPayEntry(packageName = "com.demo.payframework",entryClass = BaseWXPayActivity.class)
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
