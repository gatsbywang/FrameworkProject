package com.demo.framework.adapterforlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by 花歹 on 2018/5/21.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class CustomListView extends ScrollView {
    private LinearLayout mContainer;

    private ListAdapter mAdapter;

    public CustomListView(Context context) {
        this(context, null);
    }

    public CustomListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContainer = new LinearLayout(context);
        mContainer.setOrientation(LinearLayout.VERTICAL);
        addView(mContainer, 0);

    }

    @Override
    public void addView(View child) {
        mContainer.addView(child);
    }

    public void setAdapter(ListAdapter adapter) {
        this.mAdapter = adapter;
        //观察者，注册反注册
        int count = mAdapter.getCount();
        for (int i = 0; i < count; i++) {
            View childView = mAdapter.getView(i, this);
            addView(childView);
        }
    }
}
