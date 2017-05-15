package com.zuodong.androiddesignpatterns.ChapterEleven;

import android.graphics.Path;

/**
 * Created by dongdong on 2017/3/7.
 *
 * 圆形笔触
 */

public class CircleBrush implements IBrush {
    @Override
    public void down(Path path, float x, float y) {

    }

    @Override
    public void move(Path path, float x, float y) {
        path.addCircle(x,y,10, Path.Direction.CW);
    }

    @Override
    public void up(Path path, float x, float y) {

    }
}
