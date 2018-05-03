package com.demo.strategypattern;

import android.animation.ObjectAnimator;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ObjectAnimator animator = ObjectAnimator.ofFloat(,"scaleX",0f,1f);
        animator.setInterpolator();
        animator.setDuration();
        animator.start();
    }
}
