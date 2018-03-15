package com.demo.butterknifeframework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.butterknife.annotation.BinderView;


public class MainActivity extends AppCompatActivity {



    @BinderView(R.id.text1)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
    }

}
