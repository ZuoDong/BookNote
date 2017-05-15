package com.zuodong.androiddesignpatterns.ChapterTentySix;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by dongdong on 2017/4/27.
 *
 * MVP模式
 *
 * 中间人，这里使用弱引用的目的是在进行耗时操作的时候activity已被销毁，但还在持有该引用而造成内存泄露
 */

public abstract class BasePresenter<T> {
    protected Reference<T> mViewRef;

    public void attachView(T view){
        mViewRef = new WeakReference<T>(view);
    }

    protected T getView(){
        return mViewRef.get();
    }

    public boolean isViewAttached(){
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView(){
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
