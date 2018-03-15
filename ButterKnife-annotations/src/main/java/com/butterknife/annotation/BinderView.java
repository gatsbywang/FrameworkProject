package com.butterknife.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 花歹 on 2018/3/14.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

@Target(ElementType.FIELD) //变量名
@Retention(RetentionPolicy.CLASS) //编译时注解
public @interface BinderView {

    int value();
}
