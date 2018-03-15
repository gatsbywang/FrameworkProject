package com.demo.genericityframework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 花歹 on 2018/3/13.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);


    }

    //泛型设置上限，可以传Activity和Activity的子类
    public void startActivity(Class<? extends Activity> clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }

    //泛型设置下限,可以传BaseActivity 和baseActivity的父类
    public void startActivity1(Class<? super BaseActivity> clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }


}
