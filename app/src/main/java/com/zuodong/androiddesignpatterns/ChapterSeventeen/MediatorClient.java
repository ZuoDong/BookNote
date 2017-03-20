package com.zuodong.androiddesignpatterns.ChapterSeventeen;

/**
 * Created by dongdong on 2017/3/21.
 */

public class MediatorClient {

    public void testMediator(){
        //构造主板对象
        MainBoard mainBoard = new MainBoard();

        //构造各个零部件
        CDDevice cdDevice = new CDDevice(mainBoard);
        CPU cpu = new CPU(mainBoard);
        SoundCard soundCard = new SoundCard(mainBoard);
        GraphicsCard graphicsCard = new GraphicsCard(mainBoard);

        //将各个零部件安装到主板
        mainBoard.setCdDevice(cdDevice);
        mainBoard.setCpu(cpu);
        mainBoard.setGraphicsCard(graphicsCard);
        mainBoard.setSoundCard(soundCard);

        //开始放电影
        cdDevice.load();
    }
}
