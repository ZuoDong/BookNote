package com.administrator.opengles.activity;

import android.os.Bundle;
import android.os.SystemClock;

import com.administrator.opengles.drawPoint.IOpenGLDemo;
import com.administrator.opengles.drawPoint.OpenGLESActivity;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class DrawTriangleActivity extends OpenGLESActivity implements IOpenGLDemo{

    float vertexArray[] = {
            -0.8f, -0.4f * 1.732f, 0.0f,
            0.0f, -0.4f * 1.732f, 0.0f,
            -0.4f, 0.4f * 1.732f, 0.0f,

            0.0f, -0.0f * 1.732f, 0.0f,
            0.8f, -0.0f * 1.732f, 0.0f,
            0.4f, 0.4f * 1.732f, 0.0f,
    };
    private int index = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexArray.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertex = vbb.asFloatBuffer();
        vertex.put(vertexArray);
        vertex.position(0);

        gl.glLoadIdentity(); //设置为单位Matrix
        gl.glTranslatef(0,0,-4); //设置纵深

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY); //打开管道
        gl.glVertexPointer(3,GL10.GL_FLOAT,0,vertex);

        index++;
        index %= 10;
        SystemClock.sleep(300);
        switch (index){
            case 0:
            case 1:
            case 2:
                gl.glColor4f(1.0f,0.0f,0.0f,1.0f);
                gl.glDrawArrays(GL10.GL_TRIANGLES,0,6);
                break;
            case 3:
            case 4:
            case 5:
                gl.glColor4f(0.0f,1.0f,0.0f,1.0f);
                gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP,0,6);
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                gl.glColor4f(0.0f,0.0f,1.0f,1.0f);
                gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,0,6);
                break;
        }
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
