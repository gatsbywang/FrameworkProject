package com.demo.framework.bridge;

/**
 * Created by 花歹 on 2019/5/23.
 * Email:   gatsbywang@126.com
 * Description: 咖啡
 * Thought:
 */
public abstract class Coffee {

    protected CoffeeAdditives mAdditives;

    public   Coffee(CoffeeAdditives additives){
        this.mAdditives = additives;
    }

    //生成一杯咖啡
    public abstract void makeCoffee();
}
