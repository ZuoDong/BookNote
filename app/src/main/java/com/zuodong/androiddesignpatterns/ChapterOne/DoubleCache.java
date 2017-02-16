package com.zuodong.androiddesignpatterns.ChapterOne;

import android.graphics.Bitmap;

/**
 * Created by dongdong on 2017/1/4.
 *
 * 双缓存：内存,SD卡
 */

public class DoubleCache implements ImageCache {

    public MemoryCache memoryCache = new MemoryCache();

    public DiskCache diskCache = new DiskCache();

    @Override
    public void put(String url, Bitmap bitmap) {
        memoryCache.put(url,bitmap);
        diskCache.put(url,bitmap);
    }

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = memoryCache.get(url);
        if(bitmap == null){
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }
}
