package com.demo.umlframework;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 花歹 on 2018/3/5.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();
}
