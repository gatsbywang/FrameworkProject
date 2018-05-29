package com.demo.framework.adapterforlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CustomListView mCustomListView;

    private List<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomListView = findViewById(R.id.custom_lv);

        for (int i = 0; i < 100; i++) {
            items.add("i= " + i);
        }

        mCustomListView.setAdapter(new ListAdapter(items));
    }
}
