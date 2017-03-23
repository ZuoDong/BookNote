package com.zuodong.androiddesignpatterns.ChapterEighteen;

import java.lang.reflect.Proxy;

/**
 * Created by dongdong on 2017/3/23.
 */

public class ProxClientTest {

    public void ProxyTest(){
        //静态代理
        ILawsuit lawyer = new Lawyer(new XiaoMin());
        lawyer.submit();lawyer.burden();lawyer.defend();lawyer.finish();

        //动态代理
        ILawsuit proxyInstance = (ILawsuit) Proxy.newProxyInstance(new XiaoMin().getClass().getClassLoader(),
                new Class[]{ILawsuit.class}, new DynamicProxy());
        proxyInstance.submit();proxyInstance.burden();
        proxyInstance.defend();proxyInstance.finish();
    }
}
