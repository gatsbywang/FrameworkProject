package com.demo.iterator.simple2;

import com.demo.iterator.simple1.UserInfo;

/**
 * Created by 花歹 on 2018/9/5.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class Client {

    public static void main(String[] args) {
        //根据用户名和密码去查询用户信息，如果没有查询到那么代表登录失败。，如果查询到代表登录成功
        WXUserSystem wxUserSystem = new WXUserSystem();
        UserInfo userInfo = queryUserInfo("xx", "xx", wxUserSystem.iterator());


        //多种方式获取，可以采取责任链方式
        //采取第二种获取 比如QQ
        if(userInfo ==null){

        }

        //采取第三种获取 比如QQ
        if(userInfo ==null){

        }
    }

    private static UserInfo queryUserInfo(String userName, String userPWD, Iterator<UserInfo> iterator) {
        while (iterator.hasNext()) {
            UserInfo userInfo = iterator.next();
            if (userInfo.userName.equals(userName) && userInfo.userPwd.equals(userPWD)) {
                return userInfo;
            }

        }

        return null;
    }
}
