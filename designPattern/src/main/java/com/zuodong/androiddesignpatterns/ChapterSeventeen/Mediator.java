package com.zuodong.androiddesignpatterns.ChapterSeventeen;

/**
 * Created by dongdong on 2017/3/21.
 *
 * 抽象中介者
 */

public abstract class Mediator {
    /**
     * 对象改变由中介者通知其他对象
     *
     * @param c 同事对象
     */
    public abstract void changed(Colleague c);
}
