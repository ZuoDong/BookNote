package com.zuodong.androiddesignpatterns.ChapterTentyFour;

/**
 * Created by dongdong on 2017/4/27.
 *
 * 咖啡类
 * 包含一个添加剂类
 */

public abstract class Coffee {

    protected CoffeeAdditives impl;

    public Coffee(CoffeeAdditives impl) {
        this.impl = impl;
    }

    /**
     * 咖啡具体的样子有子类决定
     */
    public abstract void makeCoffee();
}
