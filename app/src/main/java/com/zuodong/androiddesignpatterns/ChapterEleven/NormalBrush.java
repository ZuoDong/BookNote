package com.zuodong.androiddesignpatterns.ChapterEleven;

import android.graphics.Path;

/**
 * Created by dongdong on 2017/3/7.
 *
 * 普通笔触
 */

public class NormalBrush implements IBrush {
    @Override
    public void down(Path path, float x, float y) {
        path.moveTo(x,y);
    }

    @Override
    public void move(Path path, float x, float y) {
        path.lineTo(x,y);
    }

    @Override
    public void up(Path path, float x, float y) {

    }
}
