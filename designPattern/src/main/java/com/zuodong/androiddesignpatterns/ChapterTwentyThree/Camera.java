package com.zuodong.androiddesignpatterns.ChapterTwentyThree;

/**
 * Created by dongdong on 2017/4/15.
 *
 * 手机子系统：相机
 */

public interface Camera {
    void open(); //打开相机
    void takePicture(); //拍照
    void close(); //关闭相机
}
