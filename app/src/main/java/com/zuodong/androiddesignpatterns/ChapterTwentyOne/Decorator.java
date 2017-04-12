package com.zuodong.androiddesignpatterns.ChapterTwentyOne;

/**
 * Created by dongdong on 2017/4/12.
 *
 * 抽象装饰者
 *
 * PS：Decorator 油漆匠；装饰者
 */

public abstract class Decorator extends Component {

    private Component component;//持有一个引用

    /**
     * 必要的构造方法，需要一个Component类型的对象
     * @param component
     */
    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
        component.operate();
    }

}
