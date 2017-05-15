package com.zuodong.androiddesignpatterns.ChapterTwentyOne;

/**
 * Created by dongdong on 2017/4/12.
 *
 * 装饰者具体实现
 */

public class ConcreteDecoratorA extends Decorator {
    /**
     * 必要的构造方法，需要一个Component类型的对象
     *
     * @param component
     */
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        operateA();
        super.operate();
        operateB();
    }

    private void operateB() {
        System.out.println("我是装饰方法B");
    }

    private void operateA() {
        System.out.println("我是装饰方法A");
    }


}
