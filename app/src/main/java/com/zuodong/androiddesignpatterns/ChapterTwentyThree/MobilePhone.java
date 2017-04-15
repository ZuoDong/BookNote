package com.zuodong.androiddesignpatterns.ChapterTwentyThree;

/**
 * Created by dongdong on 2017/4/15.
 */

public class MobilePhone {

    private Phone phone = new PhoneImpl();
    private Camera camera = new CameraImpl();

    public void dail(){
        phone.dail();
    }

    public void videoChat(){
        System.out.println("---->视频聊天接通中");
        camera.open();
        phone.dail();
    }

    public void hangup(){
        phone.hangup();
    }

    public void takePicture(){
        camera.open();
        camera.takePicture();
    }

    public void closeCamera(){
        camera.close();
    }
}
