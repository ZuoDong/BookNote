package com.zuodong.androiddesignpatterns.ChapterEighteen;

/**
 * Created by dongdong on 2017/3/23.
 *
 * 代理律师
 *
 * 静态代理，直接继承接口
 */

public class Lawyer implements ILawsuit {

    private ILawsuit lawsuit;

    public Lawyer(ILawsuit lawsuit) {
        this.lawsuit = lawsuit;
    }

    @Override
    public void submit() {
        lawsuit.submit();
    }

    @Override
    public void burden() {
        lawsuit.burden();
    }

    @Override
    public void defend() {
        lawsuit.defend();
    }

    @Override
    public void finish() {
        lawsuit.finish();
    }
}
