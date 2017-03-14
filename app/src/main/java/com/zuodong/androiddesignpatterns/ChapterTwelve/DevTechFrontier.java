package com.zuodong.androiddesignpatterns.ChapterTwelve;

import java.util.Observable;

/**
 * Created by dongdong on 2017/3/14.
 */

public class DevTechFrontier extends Observable {

    public void postNewPublication(String content){
        //表示状态或者内容改变
        setChanged();
        //通知所有观察者
        notifyObservers();
    }
}
