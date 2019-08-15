package com.demp.framework.mvp;

/**
 * Created by 花歹 on 2019/8/7.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public interface IMvpProxy {
    void bindAndCreatePresenter(); //绑定和解绑
    void unbindPresenter(); //绑定和解绑
}
