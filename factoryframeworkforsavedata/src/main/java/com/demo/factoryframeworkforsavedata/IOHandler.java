package com.demo.factoryframeworkforsavedata;

/**
 * Created by 花歹 on 2018/4/9.
 * Email:   gatsbywang@126.com
 * Description: 数据存储的一些规范
 * Thought:
 */

public interface IOHandler {

    void save(String key, String value);

    void save(String key, double value);

    void save(String key, int value);

    void save(String key, long value);

    void save(String key, boolean value);

    void save(String key, Object value);


    String getString(String key, String defaultValue);

    double getDouble(String key, double defaultValue);

    int getInt(String key, int defaultValue);

    long getLong(String key, long defaultValue);

    boolean getBoolean(String key, boolean defaultValue);

    Object getObject(String key);


}
