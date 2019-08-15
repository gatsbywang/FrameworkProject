package com.demp.framework.mvp;

/**
 * Created by 花歹 on 2019/8/7.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class ActivityMvpProxyImpl<V extends BaseView> extends MvpProxyImpl<V> implements ActivityMvpProxy{
    public ActivityMvpProxyImpl(V view) {
        super(view);
    }

    //不同对待，
}
