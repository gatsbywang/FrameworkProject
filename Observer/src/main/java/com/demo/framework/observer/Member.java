package com.demo.framework.observer;

/**
 * Created by 花歹 on 2018/6/4.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class Member {

    private String name;

    private String age;

    public Member(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
