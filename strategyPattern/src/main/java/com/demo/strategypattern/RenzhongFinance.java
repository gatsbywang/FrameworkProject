package com.demo.strategypattern;

/**
 * Created by 花歹 on 2018/4/27.
 * Email:   gatsbywang@126.com
 * Description: 策略模式 - 人众
 * Thought:
 */

public class RenzhongFinance implements IFinance {
    @Override
    public float finannce(int month, int money) {
        if (month == 3) {
            return money + 0.09f / 12 * month * money;
        }
        if (month == 6) {
            return money + 0.112f / 12 * month * money;
        }
        if (month == 12) {
            return money + 0.12f / 12 * month * money;
        }

        throw new IllegalArgumentException("月份不对");
    }
}
