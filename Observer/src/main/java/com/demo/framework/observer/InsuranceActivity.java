package com.demo.framework.observer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by 花歹 on 2018/6/4.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class InsuranceActivity extends AppCompatActivity {


    private EditText mNameEt;
    private EditText mAgeEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);
    }

    public void add(View view) {


        DatabaseManager.getInstanc().insert(new Member(mNameEt.getText().toString(), mAgeEt.getText().toString()));
    }

    public void finish(View view) {

        finish();
    }
}
