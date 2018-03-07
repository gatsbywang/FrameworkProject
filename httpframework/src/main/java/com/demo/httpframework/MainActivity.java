package com.demo.httpframework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.demo.httpframework.simple3.HttpCallBack;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        HttpUtils httpUtils = new HttpUtils();
        httpUtils.get(this, "url", new HashMap<String, Object>(), new HttpCallBack<Object>() {
            @Override
            public void onSuccess(Object result) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        }, true);
    }
}
