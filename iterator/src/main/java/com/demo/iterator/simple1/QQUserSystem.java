package com.demo.iterator.simple1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 花歹 on 2018/9/5.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class QQUserSystem {

    private List<UserInfo> userInfos;

    public QQUserSystem() {
        userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("huadai1", "123456", "001", "男"));
        userInfos.add(new UserInfo("huadai2", "123456", "002", "男"));
        userInfos.add(new UserInfo("huadai3", "123456", "003", "男"));
    }
}
