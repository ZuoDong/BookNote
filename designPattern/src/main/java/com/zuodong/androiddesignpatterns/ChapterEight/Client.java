package com.zuodong.androiddesignpatterns.ChapterEight;

/**
 * Created by dongdong on 2017/2/27.
 *
 * 客户端调用
 */

public class Client {
    public static void mainClient(){
        TvController tvController = new TvController();
        tvController.PowerOn();
        tvController.turnUp();
        tvController.nextChannel();
        tvController.PowerOff();
        //不会生效
        tvController.turnUp();
    }
}
