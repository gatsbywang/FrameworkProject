package com.demo.iterator.simple3.bottomTab;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

/**
 * Created by 花歹 on 2018/12/3.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class MainBottomTabItem extends BottomTabItem {

    private Builder builder;

    private MainBottomTabItem(Context context) {
        super(1, context);
    }

    public MainBottomTabItem(Builder builder) {
        this(builder.context);
        this.builder = builder;
    }

    @Override
    protected void initLayout() {
        //初始化显示
        //View view = findViewById(R.id.xxx);
        if (TextUtils.isEmpty(builder.text)) {
            //xxxx
        }
    }

    @Override
    void setSelected(boolean isSelected) {

        View view = findViewById(1);
        view.setSelected(isSelected);
    }

    public static class Builder {
        Context context;
        String text;
        int resIconId;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder resIcon(int resIconId) {
            this.resIconId = resIconId;
            return this;
        }

        public MainBottomTabItem create() {
            return new MainBottomTabItem(this);
        }


    }
}
