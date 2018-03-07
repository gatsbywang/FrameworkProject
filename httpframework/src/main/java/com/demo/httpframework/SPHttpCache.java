package com.demo.httpframework;

/**
 * Created by 花歹 on 2018/1/25.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class SPHttpCache {

    public void saveCache(String finalUrl, String resultJson) {
        PreferencesUtil.getInstance().saveParam(finalUrl, resultJson);
    }

    public String getCache(String finalUrl) {
        return (String) PreferencesUtil.getInstance().getObject(finalUrl);
    }
}
