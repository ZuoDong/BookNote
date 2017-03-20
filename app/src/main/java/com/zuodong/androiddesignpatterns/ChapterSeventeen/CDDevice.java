package com.zuodong.androiddesignpatterns.ChapterSeventeen;

/**
 * Created by dongdong on 2017/3/21.
 *
 * 光驱同事
 */

public class CDDevice extends Colleague {

    private String data;//视频数据

    public CDDevice(Mediator mediator) {
        super(mediator);
    }

    /**
     * 读取视频数据
     * @return
     */
    public String read(){
        return data;
    }

    /**
     * 加载音频数据
     */
    public void load(){
        data = "视频数据,音频数据";
        mediator.changed(this);
    }
}
