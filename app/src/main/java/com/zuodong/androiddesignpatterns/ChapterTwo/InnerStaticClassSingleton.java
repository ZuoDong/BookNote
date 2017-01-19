package com.zuodong.androiddesignpatterns.ChapterTwo;

/**
 * Created by dongdong on 2017/1/19.
 *
 * 内部静态类单例模式
 *
 * 还有枚举模式，详见28页
 */

public class InnerStaticClassSingleton {
    private InnerStaticClassSingleton(){}

    /**
     * 只有在调用的时候才会初始化mSingleton,线程安全
     * @return
     */
    public static InnerStaticClassSingleton getInstance(){
        return SingletonHolder.mSingleton;
    }

    private static class SingletonHolder{
        private static final InnerStaticClassSingleton mSingleton = new InnerStaticClassSingleton();
    }
}
