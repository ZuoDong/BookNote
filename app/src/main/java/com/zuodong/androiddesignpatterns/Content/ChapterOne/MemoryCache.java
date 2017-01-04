package com.zuodong.androiddesignpatterns.Content.ChapterOne;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by dongdong on 2017/1/4.
 * 图片LRU缓存
 */

public class MemoryCache implements ImageCache{

    LruCache<String,Bitmap> mImageChche;

    public MemoryCache() {
        initImageCache();
    }

    private void initImageCache() {

        int maxMemroy = (int) (Runtime.getRuntime().maxMemory() / 1024);

        //缓存大小
        int cacheMemory = maxMemroy / 4;

        mImageChche = new LruCache<String,Bitmap>(cacheMemory){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mImageChche.put(url,bitmap);
    }

    public Bitmap get(String key){
        return mImageChche.get(key);
    }
}
