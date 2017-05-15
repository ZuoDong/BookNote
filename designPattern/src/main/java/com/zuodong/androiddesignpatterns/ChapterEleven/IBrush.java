package com.zuodong.androiddesignpatterns.ChapterEleven;

import android.graphics.Path;

/**
 * Created by dongdong on 2017/3/7.
 *
 * 抽象笔触
 */

public interface IBrush {
    void down(Path path,float x,float y);
    void move(Path path,float x,float y);
    void up(Path path,float x,float y);
}
