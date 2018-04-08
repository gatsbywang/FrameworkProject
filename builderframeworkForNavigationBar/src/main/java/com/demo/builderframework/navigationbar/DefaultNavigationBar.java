package com.demo.builderframework.navigationbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.demo.builderframework.R;

/**
 * Created by 花歹 on 2018/4/3.
 * Email:   gatsbywang@126.com
 * Description: 默认样式导航栏
 *  默认样式导航栏，不需要关注layoutId, 由此默认样式指定
 * Thought:
 */

public class DefaultNavigationBar extends AbsNavigationBar<DefaultNavigationBar.Builder> {
    protected DefaultNavigationBar(Builder builder) {
        super(builder);
    }


    @Override
    public void attachNavigationParms() {
        super.attachNavigationParms();
        //额外的view 操作
        Builder builder = getBuilder();
    }

    /**
     * 导航栏的Builder
     *
     * 核心点  泛型的使用方式
     * 解决AbsNavigationBar.Builder 中的setText 等方法返回的是AbsNavigationBar.Builder 导致无法调用
     * NavigationBar.Builder 中的create
     */
    public static class Builder extends AbsNavigationBar.Builder<DefaultNavigationBar.Builder> {

        public Builder(Context context,  ViewGroup parent) {
            super(context, R.layout.activity_main, parent);
        }

        @Override
        public DefaultNavigationBar create() {
            return new DefaultNavigationBar(this);
        }

        public Builder setLeftText(String text) {
            //同样不需要关注left的id是什么
//            setText(R.id.xx, text);
            return this;
        }

        public Builder setLeftOnclickListener(View.OnClickListener onclickListener) {
//            setOnClickListener(R.id.xxx, onclickListener);
            return this;
        }
    }
}
