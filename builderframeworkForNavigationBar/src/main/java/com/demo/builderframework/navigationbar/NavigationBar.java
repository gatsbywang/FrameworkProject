package com.demo.builderframework.navigationbar;

import android.content.Context;
import android.view.ViewGroup;

/**
 * Created by 花歹 on 2018/4/3.
 * Email:   gatsbywang@126.com
 * Description: 这个是导航栏对外的
 * Thought:
 */

public class NavigationBar extends AbsNavigationBar {
    protected NavigationBar(Builder builder) {
        super(builder);
    }

    /**
     * 导航栏的Builder
     *
     * 核心点  泛型的使用方式
     * 解决AbsNavigationBar.Builder 中的setText 等方法返回的是AbsNavigationBar.Builder 导致无法调用
     * NavigationBar.Builder 中的create
     */
    public static class Builder extends AbsNavigationBar.Builder<NavigationBar.Builder> {

        public Builder(Context context, int layoutId, ViewGroup parent) {
            super(context, layoutId, parent);
        }

        @Override
        public NavigationBar create() {
            return new NavigationBar(this);
        }
    }
}
