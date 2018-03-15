package com.demo.aopframework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hcDarren on 2017/8/27.
 * 标记切点 注解
 */
@Target(ElementType.METHOD) // Target 放在哪个位置 哪里可以使用 FIELD属性 TYPE类上 METHOD方法
@Retention(RetentionPolicy.RUNTIME)// RUNTIME 运行时 xUtils  CLASS 代表编译时期（打包） ButterKnife   SOURCE 代表资源（编程阶段，比如@override）
public @interface CheckNet { // @interface 注解

}
