package com.demo.framework.adapterforlistview;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 花歹 on 2018/5/21.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public interface AdapterTarget {
    /**
     * 获取多少条
     *
     * @return
     */
    int getCount();

    /**
     * 获取view
     * @param position
     * @param parent
     * @return
     */
    View getView(int position, ViewGroup parent);
}
