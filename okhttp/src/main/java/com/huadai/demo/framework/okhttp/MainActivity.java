package com.huadai.demo.framework.okhttp;

import android.app.IntentService;
import android.content.res.Resources;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.HashMap;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view;

        File file =new File(getExternalCacheDir(),"cache");
        Cache cache =new Cache(file,10*1024*1024);
        OkHttpClient httpClient = new OkHttpClient.Builder().
                addInterceptor(new CacheRequestInterceptor(this)).
                cache(cache).
                addNetworkInterceptor(new CacheInterceptor()).build();
        new Retrofit.Builder().build().create();
    }
}
