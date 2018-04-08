package com.demo.builderframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.demo.builderframework.navigationbar.NavigationBar;


/**
 *  写代码的时候一个是高扩展，并不是要所有的内容和出现的问题都想到，而是在新增加功能的时候可以保证原来的代码不变
 *  对于开发者来说，需要用好最少知识原则
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new NavigationBar.Builder(this,,)
//                .setText(,"返回")
//                .setOnClickListener(, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        finish();
//                    }
//                }).create();
    }
}
