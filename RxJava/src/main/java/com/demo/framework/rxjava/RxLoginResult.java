package com.demo.framework.rxjava;

import java.util.Map;

/**
 * Created by 花歹 on 2019/7/9.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class RxLoginResult {

    private boolean isSucceed;

    private String msg;

    private Map<String,String> userInfoMaps;

    private RxLoginPlatform platform;

    public Map<String, String> getUserInfoMaps() {
        return userInfoMaps;
    }


}
