package com.zuodong.androiddesignpatterns.ChapterFive;

/**
 * Created by dongdong on 2017/2/21.
 */

public abstract class Factory {
    /**
     * 抽象工厂方法
     * 具体生产什么由子类去实现
     *
     * @param clz 产品对象类类型
     * @param <T>
     * @return 具体的产品对象
     */
    public abstract <T extends Product> T createProduct(Class<T> clz);
}
