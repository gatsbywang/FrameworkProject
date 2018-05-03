package com.demo.strategypattern;

/**
 * Created by 花歹 on 2018/4/27.
 * Email:   gatsbywang@126.com
 * Description: 策略模式 - 支付宝
 * Thought:
 */

public class ZhifubaoFinance implements IFinance {
    @Override
    public float finannce(int month, int money) {
        if (month == 3) {
            return money + 0.047f / 12 * month * money;
        }
        if (month == 6) {
            return money + 0.05f / 12 * month * money;
        }
        if (month == 12) {
            return money + 0.06f / 12 * month * money;
        }

        throw new IllegalArgumentException("月份不对");
    }
}
