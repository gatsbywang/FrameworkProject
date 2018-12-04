package com.demo.iterator.simple3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.demo.iterator.simple3.bottomTab.ListTabIterator;
import com.demo.iterator.simple3.bottomTab.MainBottomTabItem;
import com.demo.iterator.simple3.bottomTab.TabBottomNavigation;

/**
 * Created by 花歹 on 2018/12/3.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought: 1、个数不确定 2、样式不确定（单图片？文字图片？）
 */

public class TabActivity extends AppCompatActivity {

    private TabBottomNavigation mTabBottomNavigation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mTabBottomNavigation = new TabBottomNavigation(this);

        ListTabIterator<MainBottomTabItem> listIterator = new ListTabIterator<>();

        mTabBottomNavigation.addTabItem(listIterator);
    }


}
