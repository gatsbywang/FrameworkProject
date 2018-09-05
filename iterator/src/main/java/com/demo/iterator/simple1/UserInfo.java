package com.demo.iterator.simple1;

/**
 * Created by 花歹 on 2018/9/5.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class UserInfo {
    public String userName;
    public String userPwd;
    public String userId;
    public String userSex;

    public UserInfo(String userName, String userPwd, String userId, String userSex) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userId = userId;
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userId='" + userId + '\'' +
                ", userSex='" + userSex + '\'' +
                '}';
    }
}
