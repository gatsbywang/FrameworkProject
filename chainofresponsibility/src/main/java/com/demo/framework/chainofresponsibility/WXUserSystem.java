package com.demo.framework.chainofresponsibility;

/**
 * Created by 花歹 on 2019/5/13.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class WXUserSystem extends AbsUserSystemHandler {
    @Override
    public UserInfo queryUserInfo(String userName, String userPwd) {

        AbsUserSystemHandler nextHandler = getNextHandler();
        if(nextHandler !=null){
            return nextHandler.queryUserInfo(userName,userPwd);
        }
        return null;
    }

}
