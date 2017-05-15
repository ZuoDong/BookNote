package com.zuodong.androiddesignpatterns.ChapterEight;

/**
 * Created by dongdong on 2017/2/27.
 */

public class TvController implements PowerController {

    TvState mTvState;

    public void setTvState(TvState state){
        this.mTvState = state;
    }

    @Override
    public void PowerOn() {
        setTvState(new PowerOnState());
        System.out.println("开机啦");
    }

    @Override
    public void PowerOff() {
        setTvState(new PowerOffStatew());
        System.out.println("关机啦");
    }

    public void nextChannel(){
        mTvState.nextChannel();
    }

    public void prevChannel(){
        mTvState.prevChannel();
    }

    public void turnUp(){
        mTvState.turnUp();
    }

    public void turnDown(){
        mTvState.turnDown();
    }

}
