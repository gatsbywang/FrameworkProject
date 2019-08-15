package com.demp.framework.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 花歹 on 2019/7/30.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{

    private ActivityMvpProxy mMvpProxy;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1、Activity 2、Fragment 3、ViewGroup 抽离 工具类抽出去

       mMvpProxy = createMvpProxy();
       mMvpProxy.bindAndCreatePresenter();
    }

    /**
     * 创建mvp 代理
     * @return
     */
    private ActivityMvpProxy createMvpProxy() {
        if(mMvpProxy == null){
            mMvpProxy = new ActivityMvpProxyImpl<>(this);
        }

        return mMvpProxy;
    }

    public abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMvpProxy.unbindPresenter();
    }
}
