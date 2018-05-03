package com.demo.strategypattern;

/**
 * Created by 花歹 on 2018/4/27.
 * Email:   gatsbywang@126.com
 * Description: 策略模式的上下文，有点类似于android里的Context
 * 可以获取一些额外的基本信息。
 * 这个类有点多余，在实际开发中可以不写
 * <p>
 * Thought:
 */

public class FinanceContext {

    IFinance finance;

    public FinanceContext(IFinance finance) {
        this.finance = finance;
    }

    public float finance(int month, int money) {
        return finance.finannce(month, money);
    }

    //可以参考系统的服务
    public IFinance getFinance() {
        return finance;
    }
}
