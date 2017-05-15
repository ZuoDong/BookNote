package com.zuodong.androiddesignpatterns.ChapterTentyFour;

/**
 * Created by dongdong on 2017/4/27.
 */

public class BridgeTest {

    public void testBridge(){
        Ordinary ordinary = new Ordinary();
        Suagar suagar = new Suagar();

        //大杯 原味
        LargeCoffee largeCoffee = new LargeCoffee(ordinary);
        largeCoffee.makeCoffee();

        //小杯 原味
        SmallCoffee smallCoffee = new SmallCoffee(ordinary);
        smallCoffee.makeCoffee();

        //大杯 加糖
        LargeCoffee largeCoffee1 = new LargeCoffee(suagar);
        largeCoffee1.makeCoffee();

        //小杯 加糖
        SmallCoffee smallCoffee1 = new SmallCoffee(suagar);
        smallCoffee1.makeCoffee();
    }
}
