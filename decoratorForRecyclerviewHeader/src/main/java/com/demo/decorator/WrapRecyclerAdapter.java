package com.demo.decorator;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by 花歹 on 2018/4/11.
 * Email:   gatsbywang@126.com
 * Description: 装饰设计者模式-RecyclerView.Adapter，对其进行功能扩展，支持头部和底部的添加
 * Thought:
 */

public class WrapRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //原来的RecyclerView.adapter 并不支持头部和底部的添加
    private final RecyclerView.Adapter<RecyclerView.ViewHolder> mRealAdater;

    private ArrayList<View> mHeaderViews;

    private ArrayList<View> mFooterViews;

    public WrapRecyclerAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adater) {
        this.mRealAdater = adater;

        mHeaderViews = new ArrayList<>();

        mFooterViews = new ArrayList<>();

        mRealAdater.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        // Header (negative positions will throw an IndexOutOfBoundsException)
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return createHeaderFooterViewHolder(mHeaderViews.get(position));
        }

        // Adapter
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mRealAdater != null) {
            adapterCount = mRealAdater.getItemCount();
            if (adjPosition < adapterCount) {
                //
                return mRealAdater.onCreateViewHolder(parent, mRealAdater.getItemViewType(adjPosition));
            }
        }

        // Footer (off-limits positions will throw an IndexOutOfBoundsException)
        return createHeaderFooterViewHolder(mFooterViews.get(adjPosition - adapterCount));
    }

    private RecyclerView.ViewHolder createHeaderFooterViewHolder(View view) {
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public int getItemViewType(int position) {
        //把位置作为一个viewType
        return position;
    }

    public int getHeadersCount() {
        return mHeaderViews.size();
    }

    public int getFootersCount() {
        return mFooterViews.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Header (negative positions will throw an IndexOutOfBoundsException)
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return;
        }

        // Adapter
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mRealAdater != null) {
            adapterCount = mRealAdater.getItemCount();
            if (adjPosition < adapterCount) {
                //
                mRealAdater.onBindViewHolder(holder, adjPosition);
            }
        }


    }

    @Override
    public int getItemCount() { //总共返回多少条 底部+头部+真实的条数
        return mFooterViews.size() + mHeaderViews.size() + mRealAdater.getItemCount();
    }

    /**
     * 添加头部
     *
     * @param view
     */
    public void addHeaderView(View view) {
        if (!mHeaderViews.contains(view)) {
            mHeaderViews.add(view);
            notifyDataSetChanged();
        }
    }

    /**
     * 添加底部
     *
     * @param view
     */
    public void addFooterView(View view) {
        if (!mFooterViews.contains(view)) {
            mFooterViews.add(view);
            notifyDataSetChanged();
        }
    }

    /**
     * 移除头部
     *
     * @param view
     */
    public void removeHeaderView(View view) {
        if (mHeaderViews.contains(view)) {
            mHeaderViews.remove(view);
            notifyDataSetChanged();
        }
    }

    /**
     * 移除底部
     *
     * @param view
     */
    public void removedFooterView(View view) {
        if (mFooterViews.contains(view)) {
            mFooterViews.add(view);
            notifyDataSetChanged();
        }
    }

}
