package com.demo.framework.chainofresponsibility;

/**
 * Created by 花歹 on 2019/5/13.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class QQUserSystem extends AbsUserSystemHandler {
    @Override
    public UserInfo queryUserInfo(String userName, String userPwd) {
        //自己查询一把，有就返回 ，没有就交给下一个


        AbsUserSystemHandler nextHandler = getNextHandler();
        if(nextHandler !=null){
            return nextHandler.queryUserInfo(userName,userPwd);
        }
        return null;
    }
}
