package com.zuodong.androiddesignpatterns.ChapterTwentyThree;

/**
 * Created by dongdong on 2017/4/15.
 */

public class CameraImpl implements Camera {
    @Override
    public void open() {
        System.out.println("打开相机");
    }

    @Override
    public void takePicture() {
        System.out.println("拍照");
    }

    @Override
    public void close() {
        System.out.println("关闭相机");
    }
}
