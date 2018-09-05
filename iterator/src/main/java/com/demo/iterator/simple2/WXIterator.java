package com.demo.iterator.simple2;

import com.demo.iterator.simple1.UserInfo;

/**
 * Created by 花歹 on 2018/9/5.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class WXIterator implements Iterator<UserInfo> {

    UserInfo[] userInfos;
    int index = 0;

    public WXIterator() {
    }

    @Override
    public UserInfo next() {
        return userInfos[index++];
    }

    @Override
    public boolean hasNext() {
        return index < userInfos.length;
    }
}
