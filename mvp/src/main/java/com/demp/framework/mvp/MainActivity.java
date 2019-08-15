 package com.demp.framework.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @InjectPresenter
    private MulModelPresenter presenter;

    @InjectPresenter
    private BasePresenter presenter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        presenter.xx
    }


}
