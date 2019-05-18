package com.demo.famework.facade;

/**
 * Created by 花歹 on 2019/5/13.
 * Email:   gatsbywang@126.com
 * Description: 责任链设计模式- 抽象角色
 * Thought:
 */
public abstract class AbsUserSystemHandler implements IUserSystemHandler<AbsUserSystemHandler>,IUserSystem {


    private AbsUserSystemHandler nextHandler;


    public AbsUserSystemHandler getNextHandler() {
        return nextHandler;
    }

    public void nextHandler(AbsUserSystemHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
