package com.demo.framework.statuepattern;

/**
 * Created by 花歹 on 2019/5/21.
 * Email:   gatsbywang@126.com
 * Description: 付款状态下的操作
 * Thought:
 */
public class PaidStatus implements OrderOperateStatus {
    @Override
    public void pay() {
        System.out.println("不要重复支付");
    }

    @Override
    public void deliverGoods() {
        System.out.println("发货成功");
    }
}
