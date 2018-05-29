package com.demo.framework.adapterforlistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 花歹 on 2018/5/21.
 * Email:   gatsbywang@126.com
 * Description: 把数据集合适配成view - 对象适配
 * Thought:
 */

public class ListAdapter implements AdapterTarget {

    private List<String> mItems;

    public ListAdapter(List<String> mItems) {
        this.mItems = mItems;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public View getView(int position, ViewGroup parent) {
        TextView itemView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        itemView.setText(mItems.get(position));

        return itemView;
    }
}
