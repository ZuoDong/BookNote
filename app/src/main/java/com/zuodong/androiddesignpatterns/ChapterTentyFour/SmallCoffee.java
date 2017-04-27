package com.zuodong.androiddesignpatterns.ChapterTentyFour;

/**
 * Created by dongdong on 2017/4/27.
 */

public class SmallCoffee extends Coffee {

    public SmallCoffee(CoffeeAdditives impl) {
        super(impl);
    }

    @Override
    public void makeCoffee() {
        System.out.println("小杯杯的"+impl.addSomething()+"咖啡");
    }
}
