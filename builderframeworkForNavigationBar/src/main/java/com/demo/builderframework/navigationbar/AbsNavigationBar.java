package com.demo.builderframework.navigationbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 花歹 on 2018/4/3.
 * Email:   gatsbywang@126.com
 * Description:这个是导航栏的基类
 * Thought:
 */

class AbsNavigationBar implements INavigation {

    private Builder mBuilder;

    private View mNavigationBar;

    protected AbsNavigationBar(Builder builder) {
        this.mBuilder = builder;
        createNavigationBar();
    }

    @Override
    public void createNavigationBar() {

        mNavigationBar = LayoutInflater.from(mBuilder.mContext)
                .inflate(mBuilder.mLayoutId, mBuilder.mParent, false);

        //添加
        attachParent(mNavigationBar, mBuilder.mParent);

        //绑定参数
        attachNavigationParms();
    }

    /**
     * 绑定参数
     */
    @Override
    public void attachNavigationParms() {

    }

    /**
     * 将 NavigationView 添加到父布局
     *
     * @param navigationBar
     * @param parent
     */
    @Override
    public void attachParent(View navigationBar, ViewGroup parent) {
        parent.addView(navigationBar, 0);
    }

    /**
     * 返回Builder
     *
     * @return
     */
    public Builder getBuilder() {
        return mBuilder;
    }

    /**
     * Builder构建类
     * 构建 NavigationBar 还要存储参数
     */
    public static abstract class Builder<B extends Builder> {
        public Context mContext;

        public int mLayoutId;

        public ViewGroup mParent;

        public Builder(Context context, int layoutId, ViewGroup parent) {
            this.mContext = context;

            this.mLayoutId = layoutId;

            this.mParent = parent;
        }

        public B setText(int viewId, String text) {

            return (B) this;
        }

        public B setOnClickListener(int viewId, View.OnClickListener onClickListener) {

            return (B) this;
        }

        /**
         * 用来创建
         *
         * @return
         */
        public abstract AbsNavigationBar create();

    }
}
