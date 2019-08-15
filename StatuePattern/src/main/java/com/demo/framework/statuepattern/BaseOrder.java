package com.demo.framework.statuepattern;

/**
 * Created by 花歹 on 2019/5/21.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class BaseOrder {
    protected OrderOperateStatus mStatus;

    public void setStatus(OrderOperateStatus status){
        this.mStatus = status;
    }
}
