package com.zuodong.androiddesignpatterns.ChapterSeventeen;

/**
 * Created by dongdong on 2017/3/21.
 */

public class MainBoard extends Mediator {

    private CDDevice cdDevice;
    private CPU cpu;
    private GraphicsCard graphicsCard;
    private SoundCard soundCard;

    @Override
    public void changed(Colleague c) {
        //光驱读取数据
        if(c == cdDevice){
            handleCD((CDDevice)c);
        }

        if(c == cpu){
            handleCPU((CPU)c);
        }
    }

    /**
     * 处理cpu读取数据后与其他设备的交互
     * @param c
     */
    private void handleCPU(CPU c) {
        soundCard.soundPlay(c.getDataSound());
        graphicsCard.videoPlay(c.getDataVideo());
    }

    /**
     * 处理光驱读取数据后与其他设备的交互
     * @param c
     */
    private void handleCD(CDDevice c) {
        cpu.decodeData(c.read());
    }


    public void setCdDevice(CDDevice cdDevice) {
        this.cdDevice = cdDevice;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setGraphicsCard(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }
}
