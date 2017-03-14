package com.zuodong.androiddesignpatterns.ChapterTwelve;

/**
 * Created by dongdong on 2017/3/14.
 */

public class ObserverTest {

    public void testObserver(){
        //被观察者
        DevTechFrontier devTechFrontier = new DevTechFrontier();
        //观察者
        Coder coder1 = new Coder("coder-1");
        Coder coder2 = new Coder("coder-2");

        //将观察者注册到被观察者的列表中
        devTechFrontier.addObserver(coder1);
        devTechFrontier.addObserver(coder2);

        //发布消息
        devTechFrontier.postNewPublication("新的消息来了");
    }
}
