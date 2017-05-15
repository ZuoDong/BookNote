package com.zuodong.androiddesignpatterns.ChapterEleven;

import android.graphics.Canvas;

/**
 * Created by dongdong on 2017/3/7.
 *
 * 绘制命令接口
 */

public interface IDraw {
    void draw(Canvas canvas);
    void undo();
}
