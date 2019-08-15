package com.demo.framework.bridge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Sugar sugar = new Sugar();
        SmallCoffee smallCoffee = new SmallCoffee(sugar);
        smallCoffee.makeCoffee();;

        //一个对象依赖另一个对象，所依赖的是接口，直接没有紧密的联系
        Original original = new Original();
        LargeCoffee largeCoffee = new LargeCoffee(original);
        largeCoffee.makeCoffee();
    }
}
