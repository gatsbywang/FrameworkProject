package com.huadai.demo.framework.okhttp.retrofit;

import java.util.Observable;

/**
 * Created by 花歹 on 2019/7/14.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class Result<T> extends BaseResult{
    public Object data;


    public boolean isOK(){
        return false;
    }

}
