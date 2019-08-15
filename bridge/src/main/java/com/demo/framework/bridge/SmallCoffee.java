package com.demo.framework.bridge;

/**
 * Created by 花歹 on 2019/5/23.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class SmallCoffee extends Coffee {
    public SmallCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("小杯的"+mAdditives);
    }
}
