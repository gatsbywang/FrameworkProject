package com.demo.prototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("params1", "params1");
        intent.putExtra("params2", "params2");
        intent.putExtra("params3", "params3");
    }
}
