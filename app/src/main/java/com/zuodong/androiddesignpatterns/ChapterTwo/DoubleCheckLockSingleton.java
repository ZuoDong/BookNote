package com.zuodong.androiddesignpatterns.ChapterTwo;

/**
 * Created by dongdong on 2017/1/19.
 *
 * Double CheckLock(DCL)实现单例
 *
 * 相比于懒汉模式更加节省资源，不用每次都去进行同步加锁
 */

public class DoubleCheckLockSingleton {
    /**
     * volatile保证了Java虚拟机的执行顺序
     */
    private static volatile DoubleCheckLockSingleton sInstance = null;

    private DoubleCheckLockSingleton(){}

    /**
     * sInstance = new DoubleCheckLockSingleton()执行了多条汇编程序
     * 大致为：1.Singleton分配内存2.调用Singleton()初始化成员字段3.将sInstance对象指向内存
     */
    public static DoubleCheckLockSingleton getInstance(){
        if(sInstance == null){
            synchronized (DoubleCheckLockSingleton.class){
                if(sInstance == null){
                    sInstance = new DoubleCheckLockSingleton();
                }
            }
        }
        return sInstance;
    }
}
