package com.huadai.demo.framework.okhttp.retrofit.http;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 花歹 on 2019/7/17.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface POST {

    String value();


}
