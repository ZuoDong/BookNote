package com.zuodong.androiddesignpatterns.ChapterEighteen;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by dongdong on 2017/3/23.
 *
 * 动态代理
 * 执行阶段才知道代理的谁
 */

public class DynamicProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxy,args);
    }
}
