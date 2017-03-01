package com.zuodong.androiddesignpatterns.ChapterNight;

/**
 * Created by dongdong on 2017/3/1.
 */

public class RequestPeople {

    public void handleRequest(){
        //构造各个领导对象
        GroupLeader groupLeader = new GroupLeader();
        Director director = new Director();
        Manger manger = new Manger();
        Boss boss = new Boss();

        //设置上一级领导处理对象
        groupLeader.nextLeader = director;
        director.nextLeader = manger;
        manger.nextLeader = boss;

        //发起报账申请
        groupLeader.handleRequest(50000);
    }
}
