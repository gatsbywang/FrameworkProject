package com.demo.decorator;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 花歹 on 2018/4/12.
 * Email:   gatsbywang@126.com
 * Description: 单纯的只改动adapter是不行，面向对象的六大原则体现不了，
 *              必须构造一个自定义recyclerView,让调用者可以不用知道内部实现，即可完成头部和底部的添加
 *      不要过度封装，业务逻辑能分开就分开
 * Thought:
 */

public class WrapRecyclerView extends RecyclerView {

    private WrapRecyclerAdapter mAdapter;

    public WrapRecyclerView(Context context) {
        this(context, null);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        mAdapter = new WrapRecyclerAdapter(adapter);
        super.setAdapter(mAdapter);
    }

    /**
     * 添加头部
     *
     * @param view
     */
    public void addHeaderView(View view) {
        //必须设置Adapter之后 才可以添加
        if (mAdapter != null) {
            mAdapter.addHeaderView(view);
        }
    }

    /**
     * 添加底部
     *
     * @param view
     */
    public void addFooterView(View view) {
        if (mAdapter != null) {
            mAdapter.addFooterView(view);
        }
    }

    /**
     * 移除头部
     *
     * @param view
     */
    public void removeHeaderView(View view) {
        if (mAdapter != null) {
            mAdapter.removeHeaderView(view);
        }
    }

    /**
     * 移除底部
     *
     * @param view
     */
    public void removedFooterView(View view) {
        if (mAdapter != null) {
            mAdapter.removedFooterView(view);
        }
    }
}
