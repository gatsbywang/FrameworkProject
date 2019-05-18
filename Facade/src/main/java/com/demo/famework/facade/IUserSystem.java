package com.demo.famework.facade;

/**
 * Created by 花歹 on 2019/5/13.
 * Email:   gatsbywang@126.com
 * Description: 校验用户的处理接口
 * Thought:
 */
public interface IUserSystem {

     UserInfo queryUserInfo(String userName, String userPwd);
}
