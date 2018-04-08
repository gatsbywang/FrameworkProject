package com.demo.builderframework.navigationbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 花歹 on 2018/4/3.
 * Email:   gatsbywang@126.com
 * Description:这个是导航栏的基类
 * Thought:
 */

class AbsNavigationBar<B extends AbsNavigationBar.Builder> implements INavigation {

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
        Map<Integer, CharSequence> textMaps = mBuilder.mTextMaps;
        for (Map.Entry<Integer, CharSequence> entry : textMaps.entrySet()) {
            TextView textView = findViewById(entry.getKey());
            textView.setText(entry.getValue());
        }

        Map<Integer, View.OnClickListener> clickMaps = mBuilder.mClickListenerMaps;
        for (Map.Entry<Integer, View.OnClickListener> entry : clickMaps.entrySet()) {
            View view = findViewById(entry.getKey());
            view.setOnClickListener(entry.getValue());
        }
    }

    public <T extends View> T findViewById(int viewId) {

        return (T) mNavigationBar.findViewById(viewId);
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
    public B getBuilder() {
        return (B)mBuilder;
    }

    /**
     * Builder构建类
     * 构建 NavigationBar 还要存储参数
     */
    public static abstract class Builder<B extends Builder> {
        public Context mContext;

        public int mLayoutId;

        public ViewGroup mParent;

        private Map<Integer, CharSequence> mTextMaps;

        public Map<Integer, View.OnClickListener> mClickListenerMaps;

        public Builder(Context context, int layoutId, ViewGroup parent) {
            this.mContext = context;

            this.mLayoutId = layoutId;

            this.mParent = parent;

            this.mTextMaps = new HashMap<>();
        }

        /**
         * 设置文本
         *
         * @param viewId
         * @param text
         * @return
         */
        public B setText(int viewId, String text) {

            mTextMaps.put(viewId, text);
            return (B) this;
        }

        /**
         * 设置点击事件
         *
         * @param viewId
         * @param onClickListener
         * @return
         */
        public B setOnClickListener(int viewId, View.OnClickListener onClickListener) {

            mClickListenerMaps.put(viewId, onClickListener);
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
