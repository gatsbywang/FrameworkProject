package com.demo.prototype;

/**
 * Created by 花歹 on 2018/9/4.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class User implements Cloneable {

    private String name;

    private Address address;

    @Override
    protected Object clone() throws CloneNotSupportedException {

        User user = (User) super.clone();
        user.address = (Address) user.address.clone();//把地址也clone 达到深拷贝


        return user;
    }

    public static class Address implements Cloneable{
        String name;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
