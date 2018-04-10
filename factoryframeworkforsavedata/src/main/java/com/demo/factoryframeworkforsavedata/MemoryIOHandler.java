package com.demo.factoryframeworkforsavedata;

import android.util.LruCache;

import javax.crypto.Mac;

/**
 * Created by 花歹 on 2018/4/9.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class MemoryIOHandler implements IOHandler {

    //其实是个Map集合
    private static LruCache<String, Object> mCache = new LruCache<>(10*1024*1024);

    @Override

    public void save(String key, String value) {
        mCache.put(key, value);
    }

    @Override
    public void save(String key, double value) {

    }

    @Override
    public void save(String key, int value) {

    }

    @Override
    public void save(String key, long value) {

    }

    @Override
    public void save(String key, boolean value) {

    }

    @Override
    public void save(String key, Object value) {

    }

    @Override
    public String getString(String key, String defaultValue) {
        return (String) mCache.get(key);
    }

    @Override
    public double getDouble(String key, double defaultValue) {
        return 0;
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return 0;
    }

    @Override
    public long getLong(String key, long defaultValue) {
        return 0;
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return false;
    }

    @Override
    public Object getObject(String key) {
        return null;
    }
}
