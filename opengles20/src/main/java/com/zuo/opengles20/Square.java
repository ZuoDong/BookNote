package com.zuo.opengles20;

import android.content.Context;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * 作者：zuo
 * 时间：2017/6/30:14:04
 */

public class Square {

    private static int BYTES_PRE_FLOAT = 4;
    private static int COORDS_PRE_VERTEX = 2;
    private static float[] vertexCoords = {-0.5f,0.5f,0.5f,0.5f,0.5f,-0.5f,-0.5f,-0.5f};
    private final FloatBuffer vertexBuffer;
    private Context context;

    public Square(Context context) {
        this.context = context;

        vertexBuffer = ByteBuffer
                .allocateDirect(vertexCoords.length * BYTES_PRE_FLOAT)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        // 把坐标们加入FloatBuffer中
        vertexBuffer.put(vertexCoords);
        // 设置buffer，从第一个坐标开始读
        vertexBuffer.position(0);
    }
}
