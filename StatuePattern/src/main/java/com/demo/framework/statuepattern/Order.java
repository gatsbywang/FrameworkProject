package com.demo.framework.statuepattern;

/**
 * Created by 花歹 on 2019/5/21.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class Order extends BaseOrder implements OrderOperateStatus{

    public Order(){
        mStatus = new ObligationStatus();
    }

    @Override
    public void pay() {
        mStatus.pay();
        setStatus(new PaidStatus());
    }

    @Override
    public void deliverGoods() {
        mStatus.deliverGoods();
        setStatus(new WaitRecevingStatus());
    }
}
