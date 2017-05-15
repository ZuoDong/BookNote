package com.zuodong.androiddesignpatterns.ChapterTwentyThree;

/**
 * Created by dongdong on 2017/4/15.
 *
 * 外观模式 又称门面(facade)模式
 */

public class FacadeTest {

    public void testFacade(){
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.takePicture();
        mobilePhone.videoChat();
    }
}
