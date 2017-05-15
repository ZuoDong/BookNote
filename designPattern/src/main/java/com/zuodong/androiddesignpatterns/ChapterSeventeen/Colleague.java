package com.zuodong.androiddesignpatterns.ChapterSeventeen;

/**
 * Created by dongdong on 2017/3/21.
 *
 * 抽象同事
 */

public abstract class Colleague {

    protected Mediator mediator;//每个对象应该有一个中介者

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
