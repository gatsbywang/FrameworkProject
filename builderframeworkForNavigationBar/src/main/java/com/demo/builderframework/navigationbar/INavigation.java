package com.demo.builderframework.navigationbar;

import android.view.View;
import android.view.ViewGroup;

/**
 * 导航栏的规范
 * Created by 花歹 on 2018/4/3.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public interface INavigation {

    void createNavigationBar();

    void attachNavigationParms();

    void attachParent(View navigationBar, ViewGroup parent);
}
