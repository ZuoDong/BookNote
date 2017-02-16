package com.zuodong.androiddesignpatterns.ChapterOne;

/**
 * Created by dongdong on 2017/2/16.
 */

public class ImageLoadConfig {

    ImageCache imageCache = new MemoryCache();

    DisplayConfig displayConfig = new DisplayConfig();

    int threadCount = Runtime.getRuntime().availableProcessors() + 1;

    //构建与表示相脱离
    private ImageLoadConfig(){}

    /**
     * 配置类Builder
     */
    public static class Builder{

        private ImageCache imageCache = new MemoryCache();

        private DisplayConfig displayConfig = new DisplayConfig();

        private int threadCount = Runtime.getRuntime().availableProcessors() + 1;

        public Builder setThreadCount(int count){
            threadCount = Math.max(1,count);
            return this;
        }

        public Builder setCache(ImageCache cache){
            imageCache = cache;
            return this;
        }

        public Builder setLoadingPlaceHolder(int resId){
            displayConfig.loadingResId = resId;
            return this;
        }

        public Builder setNotFoundPlaceholder(int resId){
            displayConfig.failResId = resId;
            return this;
        }

        public void applyConfig(ImageLoadConfig config){
            config.imageCache = this.imageCache;
            config.displayConfig = this.displayConfig;
            config.threadCount = this.threadCount;
        }

        //创建配置对象
        public ImageLoadConfig create(){
            ImageLoadConfig config = new ImageLoadConfig();
            applyConfig(config);
            return config;
        }

    }
}
