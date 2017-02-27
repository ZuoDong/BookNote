package com.zuodong.androiddesignpatterns.ChapterEight;

/**
 * Created by dongdong on 2017/2/27.
 *
 * 状态模式：主要用来拆分if-else
 *
 * 电视遥控器的状态,主要分为开机和关机，功能键受这两种状态的影响
 */

public interface TvState {
    public void nextChannel();
    public void prevChannel();
    public void turnUp();
    public void turnDown();
}
