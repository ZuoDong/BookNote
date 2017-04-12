package com.zuodong.androiddesignpatterns.ChapterTwentyOne;

/**
 * Created by dongdong on 2017/4/12.
 *
 * 组件具体的实现类
 *
 * PS：Concrete 具体的;混凝土
 */

public class ConcreteComponent extends Component {

    @Override
    public void operate() {
        System.out.println("我是原始的方法");
    }
}
