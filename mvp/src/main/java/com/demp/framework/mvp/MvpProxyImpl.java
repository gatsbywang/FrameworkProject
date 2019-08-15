package com.demp.framework.mvp;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 花歹 on 2019/8/7.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class MvpProxyImpl<V extends BaseView> implements IMvpProxy {

    private V mView;

    private List<BasePresenter> mPresenters; //为了解绑

   public MvpProxyImpl(V view){
       this.mView =view;
       mPresenters = new ArrayList<>();
   }

    @Override
    public void bindAndCreatePresenter() {

        //注入Presenter 反射
        Field[] fields = mView.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectPresenter injectPresenter = field.getAnnotation(InjectPresenter.class);
            if(injectPresenter !=null){
                Class<? extends BasePresenter> presenterClazz = null;
//                try {
//                    presenterClazz = (Class<? extends BasePresenter>) field.getType(); //会存在泛型擦除
//                }catch (Exception e){
//                    throw new RuntimeException("no support inject presenter type!" + field.getName());
//                }
                presenterClazz = (Class) field.getType();
                if(BasePresenter.class.isAssignableFrom(presenterClazz)){
                    //这个Class 是不是继承自BasePresenter 如果不是，抛异常
                    throw new RuntimeException("no support inject presenter type!" + presenterClazz.getName());
                }


                BasePresenter basePresenter = null;
                try {

                    //创建对象
                    basePresenter = presenterClazz.newInstance();
                    basePresenter.attach(mView);
                    field.setAccessible(true);
                    field.set(mView,basePresenter);
                    mPresenters.add(basePresenter);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //检测view层 实现了presenter的view接口
                checkView(basePresenter);
            }
        }
    }

    /**
     * //检测view层 实现了presenter的view接口
     * @param basePresenter
     */
    private void checkView(BasePresenter basePresenter) {
        //1、拿到BasePresenter的View接口
        Type[] params = ((ParameterizedType) basePresenter.getClass().getGenericSuperclass()).getActualTypeArguments();
        Class viewClazz = (Class) params[0];

        //2、要拿到View层的所有接口

        Class[] viewClasses = mView.getClass().getInterfaces();
        boolean isImplView= false;
        for (Class viewClass : viewClasses) {
            if(viewClass.isAssignableFrom(viewClazz)){
                isImplView = true;
            }
        }

        if(!isImplView){
            throw new RuntimeException(mView.getClass().getSimpleName() + " must implements "+ viewClazz.getName());
        }

    }

    @Override
    public void unbindPresenter() {
        for (BasePresenter presenter : mPresenters) {
            presenter.detach();
        }
        mView = null;
    }
}
