package com.demo.iterator.simple3.bottomTab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 花歹 on 2018/12/4.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class ListTabIterator<T extends BottomTabItem> implements TabIterator {


    private List<T> mTaItems;
    private int index;

    public ListTabIterator() {
        mTaItems = new ArrayList<>();
    }

    public void addItem(T item) {
        mTaItems.add(item);
    }

    @Override
    public BottomTabItem next() {
        return mTaItems.get(index);
    }

    @Override
    public boolean hashNext() {
        return index < mTaItems.size();
    }
}
