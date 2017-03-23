package com.zuodong.androiddesignpatterns.ChapterEighteen;

/**
 * Created by dongdong on 2017/3/23.
 *
 * 具体诉讼人
 */

public class XiaoMin implements ILawsuit {

    @Override
    public void submit() {
        System.out.println("申请材料提交");
    }

    @Override
    public void burden() {
        System.out.println("近一年工资流水");
    }

    @Override
    public void defend() {
        System.out.println("证据充足，事实清楚");
    }

    @Override
    public void finish() {
        System.out.println("诉讼成功");
    }
}
