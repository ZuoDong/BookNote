package com.zuodong.androiddesignpatterns.ChapterEighteen;

/**
 * Created by dongdong on 2017/3/23.
 *
 * 诉讼接口
 */

public interface ILawsuit {
    //提交申请
    void submit();
    //进行举证
    void burden();
    //开始辩护
    void defend();
    //诉讼完成
    void finish();
}
