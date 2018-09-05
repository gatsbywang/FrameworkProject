package com.demo.iterator.simple2;

import com.demo.iterator.simple1.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 花歹 on 2018/9/5.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class WXUserSystem implements Aggregate<UserInfo>{
    private List<UserInfo> userInfos;

    public WXUserSystem() {
        userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("huadai4", "123456", "001", "男"));
        userInfos.add(new UserInfo("huadai5", "123456", "002", "男"));
        userInfos.add(new UserInfo("huadai6", "123456", "003", "男"));
    }

    @Override
    public Iterator<UserInfo> iterator() {
        return new WXIterator();
    }
}
