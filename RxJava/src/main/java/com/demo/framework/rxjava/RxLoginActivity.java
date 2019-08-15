package com.demo.framework.rxjava;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

/**
 * Created by 花歹 on 2019/7/10.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class RxLoginActivity extends AppCompatActivity {

    public static final String PLATFORM_KEY = "PLATFORM_KEY";


    // ument api


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //umeng 初始化

        RxLoginPlatform platform= (RxLoginPlatform) getIntent().getSerializableExtra(PLATFORM_KEY);

    }

    //非void返回类型，应该为umeng的返回类型  转换为umeng 的platform
    public void platformExchange(RxLoginPlatform platform) {
        switch (platform) {
            case Platform_QQ:
            return; //转为QQ平台
            case Platform_weixin:
            return; //转为微信 平台
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
