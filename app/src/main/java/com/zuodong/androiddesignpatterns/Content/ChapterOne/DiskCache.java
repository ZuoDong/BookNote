package com.zuodong.androiddesignpatterns.Content.ChapterOne;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by dongdong on 2017/1/4.
 *
 * SD卡缓存类
 */

public class DiskCache implements ImageCache {

    // TODO: 2017/1/4 可以使用DiskLruCache,并且申请权限
    static String cacheDir = "sdcard/cache";

    @Override
    public void put(String url, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheDir + url);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                }catch (IOException e){
                   e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(cacheDir + url);
    }
}
