package com.demo.prototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String params1 = getIntent().getStringExtra("params1");
//        String params2 =getIntent().getStringExtra("params2");
//        String params3 =getIntent().getStringExtra("params3");
//
//        Intent intent = new Intent(this, MainActivity3.class);
//        intent.putExtra("params1", params1);
//        intent.putExtra("params2", params2);
//        intent.putExtra("params3", params3);


        //利用原型模式
        Intent intent = (Intent) getIntent().clone();
        intent.setClass(this, MainActivity3.class);

    }
}
