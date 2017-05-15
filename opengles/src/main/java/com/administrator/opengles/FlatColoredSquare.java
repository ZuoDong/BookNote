package com.administrator.opengles;

import javax.microedition.khronos.opengles.GL10;

/**
 * 作者：zuo
 * 时间：2017/5/15:16:27
 */

public class FlatColoredSquare extends Square {

    @Override
    public void draw(GL10 gl) {
        gl.glColor4f(0.5f, 0.5f, 1.0f, 1.0f);
        super.draw(gl);
    }
}
