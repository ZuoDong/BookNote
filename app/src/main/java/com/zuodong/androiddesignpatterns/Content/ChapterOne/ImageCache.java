package com.zuodong.androiddesignpatterns.Content.ChapterOne;

import android.graphics.Bitmap;

/**
 * Created by dongdong on 2017/1/4.
 * 图片缓存接口类
 *
 */

interface ImageCache {
    void put(String url,Bitmap bitmap);
    Bitmap get(String url);
}
