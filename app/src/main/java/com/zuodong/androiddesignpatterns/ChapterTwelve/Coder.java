package com.zuodong.androiddesignpatterns.ChapterTwelve;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by dongdong on 2017/3/14.
 *
 * 观察者
 */

public class Coder implements Observer {

    private String name;

    public Coder(String aName) {
        name = aName;
    }

    @Override
    public void update(Observable observable, Object data) {
        System.out.println("Hi,"+name+",你订阅的内容更新了,内容:"+data);
    }

    @Override
    public String toString() {
        return "码农 : " + name;
    }
}
