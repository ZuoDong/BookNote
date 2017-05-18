package com.administrator.opengles.earth;

import javax.microedition.khronos.opengles.GL10;

/**
 * 作者：zuo
 * 时间：2017/5/18:15:25
 */

public interface IEOpenGLDemo {
    void DrawScene(GL10 gl);
    void initLight(GL10 gl);
    void initObject(GL10 gl);
}
