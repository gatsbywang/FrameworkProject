package com.demo.payannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 花歹 on 2018/3/20.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface WXPayEntry {

    /**
     * 包名
     * @return
     */
    String packageName();

    /**
     * 类的class
     * @return
     */
    Class<?> entryClass();
}
