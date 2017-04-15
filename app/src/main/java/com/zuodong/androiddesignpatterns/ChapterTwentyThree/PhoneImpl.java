package com.zuodong.androiddesignpatterns.ChapterTwentyThree;

/**
 * Created by dongdong on 2017/4/15.
 */

public class PhoneImpl implements Phone {

    @Override
    public void dail() {
        System.out.println("打电话");
    }

    @Override
    public void hangup() {
        System.out.println("挂断");
    }
}
