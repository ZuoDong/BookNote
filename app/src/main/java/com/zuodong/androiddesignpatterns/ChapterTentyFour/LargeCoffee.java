package com.zuodong.androiddesignpatterns.ChapterTentyFour;

/**
 * Created by dongdong on 2017/4/27.
 */

public class LargeCoffee extends Coffee {

    public LargeCoffee(CoffeeAdditives impl) {
        super(impl);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯的"+impl.addSomething()+"咖啡");
    }
}
