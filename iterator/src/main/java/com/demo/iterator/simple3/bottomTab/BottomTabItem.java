package com.demo.iterator.simple3.bottomTab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by 花歹 on 2018/12/3.
 * Email:   gatsbywang@126.com
 * Description: 基类
 * Thought:  1、个数不确定 2、样式不确定（单图片？文字图片？）
 */

public abstract class BottomTabItem {

    //布局，传id，上下文context,最好采用Builder设计模式
    // 底部的子Item
    private View mTabItemView;

    private int mLayoutId;

    private Context mContext;

    public BottomTabItem(int layoutId, Context context) {
        this.mLayoutId = layoutId;
        this.mContext = context;
    }


    /**
     * 获取底部条目
     * @return
     */
    public View getTabView() {

        if (mTabItemView == null) {
            mTabItemView = LayoutInflater.from(mContext).inflate(mLayoutId, null);
            initLayout();
        }

        return mTabItemView;

    }

    /**
     * 初始化条目显示
     */
    protected abstract void initLayout();


    protected <T> T findViewById(int id) {
        return (T) mTabItemView.findViewById(id);
    }

    /**
     * 是否选中当前条目
     *
     * @param isSelected
     */
    abstract void setSelected(boolean isSelected);
}
