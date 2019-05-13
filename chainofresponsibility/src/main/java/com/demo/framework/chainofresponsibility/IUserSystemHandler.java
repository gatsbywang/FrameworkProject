package com.demo.framework.chainofresponsibility;

/**
 * Created by 花歹 on 2019/5/13.
 * Email:   gatsbywang@126.com
 * Description: 责任链模式-抽象处理者接口
 * Thought:
 */
public interface IUserSystemHandler<T extends IUserSystemHandler> {

    public void nextHandler(T systemHandler);
}
