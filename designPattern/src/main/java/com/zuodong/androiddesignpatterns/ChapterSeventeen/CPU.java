package com.zuodong.androiddesignpatterns.ChapterSeventeen;

/**
 * Created by dongdong on 2017/3/21.
 */

public class CPU extends Colleague {

    private String dataVideo,dataSound;

    public CPU(Mediator mediator) {
        super(mediator);
    }

    public String getDataVideo() {
        return dataVideo;
    }

    public String getDataSound() {
        return dataSound;
    }

    /**
     * 解析数据
     * @param data
     */
    public void decodeData(String data){
        String[] split = data.split(",");
        dataVideo = split[0];
        dataSound = split[1];
        mediator.changed(this);
    }
}
