package com.administrator.opengles.activity;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.administrator.opengles.drawPoint.IOpenGLDemo;
import com.administrator.opengles.drawPoint.OpenGLESActivity;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class DrawLineActivity extends OpenGLESActivity implements IOpenGLDemo{

    float vertexArray[] = {
            -0.8f, -0.4f * 1.732f, 0.0f,
            -0.4f, 0.4f * 1.732f, 0.0f,
            0.0f, -0.4f * 1.732f, 0.0f,
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

        gl.glLoadIdentity();
        gl.glTranslatef(0,0,-4);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3,GL10.GL_FLOAT,0,vertex);

        index++;
        index %= 10;
        SystemClock.sleep(300);
        switch (index){
            case 0:
            case 1:
            case 2:
                gl.glColor4f(1.0f,0.0f,0.0f,1.0f);
                gl.glDrawArrays(GL10.GL_LINES,0,4);
                break;
            case 3:
            case 4:
            case 5:
                gl.glColor4f(0.0f,1.0f,0.0f,1.0f);
                gl.glDrawArrays(GL10.GL_LINE_STRIP,0,4);
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                gl.glColor4f(0.0f,0.0f,1.0f,1.0f);
                gl.glDrawArrays(GL10.GL_LINE_LOOP,0,4);
                break;
        }
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}