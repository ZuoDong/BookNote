package com.zuodong.androiddesignpatterns.ChapterTwentyOne;

/**
 * Created by dongdong on 2017/4/12.
 */

public class DecoratorTest {

    public void textMain(){
        //构造被装饰的组件对象
        Component component = new ConcreteComponent();

        //A装饰者
        Decorator decoratorA = new ConcreteDecoratorA(component);
        decoratorA.operate();

        //B装饰者
        Decorator decoratorB = new ConcreteDecoratorB(component);
        decoratorB.operate();
    }
}
