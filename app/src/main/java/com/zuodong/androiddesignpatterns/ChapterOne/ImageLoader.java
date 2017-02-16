package com.zuodong.androiddesignpatterns.ChapterOne;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by dongdong on 2016/12/31.
 *
 * 单一职责
 * 图片加载器
 */

public class ImageLoader {

    private ImageLoadConfig mConfig;

    private static volatile ImageLoader imageLoader;

    private ImageLoader(){
        //初始化默认配置
        mConfig = new ImageLoadConfig.Builder().create();
    }

    //单例模式
    public static ImageLoader getInstance(){
        if(imageLoader == null){
            synchronized (ImageLoader.class){
                if(imageLoader == null){
                    imageLoader = new ImageLoader();
                }
            }
        }
        return imageLoader;
    }

    public void init(ImageLoadConfig config){
        mConfig = config;
        //检查配置合法性
        checkConfig();
    }

    private void checkConfig() {

    }

    //线程池
    ExecutorService mExecutorService = Executors.newFixedThreadPool(mConfig.threadCount);


    public void displayimage(final String url,final ImageView imageView){

        //先从缓存中取
        Bitmap bitmap = mConfig.imageCache.get(url);
        if(bitmap != null){
            imageView.setImageBitmap(bitmap);
            return;
        }

        //没有的话再请求网络
        imageView.setTag(url);

        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if(bitmap == null){
                    return;
                }
                if(imageView.getTag().equals(url)){
                    imageView.setImageBitmap(bitmap);
                }
                mConfig.imageCache.put(url,bitmap);
            }
        });
    }

    //放入线程池中
    private Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if(urlConnection.getResponseCode() == 200){
                bitmap = BitmapFactory.decodeStream(urlConnection.getInputStream());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
