package com.zuodong.androiddesignpatterns.ChapterOne;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by dongdong on 2017/1/5.
 *
 * 接口隔离原则-16
 *
 * 客户端不应该依赖它不需要的接口
 * 目的是系统解开耦合，从而容易重构，更改，和重新部署
 */

public class CloseUtils {

    public CloseUtils() {}

    /**
     * 关闭Closeable对象
     * @param closeable
     */
    public static void closeQuietly(Closeable closeable){
        if(null != closeable){
            try {
                closeable.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
