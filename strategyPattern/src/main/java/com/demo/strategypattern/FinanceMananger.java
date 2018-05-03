package com.demo.strategypattern;

/**
 * Created by 花歹 on 2018/4/27.
 * Email:   gatsbywang@126.com
 * Description: 资金管理类 一般写法
 * Thought:
 */

public class FinanceMananger {

    public enum Finace {
        ZHI_FU_BAO, REN_ZHONG_JIN_FU //还有很多，那么会导致这个类越来越庞大，每种利息不一样，必须新增
    }


    public float zhifubaoFinance(int month, int money) {
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

    public float renzhongjinfuFinance(int month, int money) {
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

    public float finance(int month, int money, Finace finace) {
        switch (finace) {

            case ZHI_FU_BAO:
                return zhifubaoFinance(month, money);
            case REN_ZHONG_JIN_FU:
                return zhifubaoFinance(month, money);
            default:
                return 0f;
        }
    }


}
