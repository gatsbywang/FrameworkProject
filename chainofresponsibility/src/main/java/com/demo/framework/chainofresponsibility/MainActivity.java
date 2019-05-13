package com.demo.framework.chainofresponsibility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 责任链设计模式
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WXUserSystem wxUserSystem = new WXUserSystem();
        QQUserSystem qqUserSystem = new QQUserSystem();

        wxUserSystem.nextHandler(qqUserSystem);
        wxUserSystem.queryUserInfo("","");


    }
}
