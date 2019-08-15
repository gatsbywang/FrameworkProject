package com.demo.framework.bridge;

/**
 * Created by 花歹 on 2019/5/23.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class LargeCoffee extends Coffee {
    public LargeCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯的"+mAdditives);
    }
}
