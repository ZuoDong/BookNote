package com.administrator.opengles.drawPoint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class PointActivity extends OpenGLESActivity implements IOpenGLDemo{

    float[] vertexArray = new float[]{
            -0.8f , -0.4f * 1.732f , 0.0f ,
            0.8f , -0.4f * 1.732f , 0.0f ,
            0.0f , 0.4f * 1.732f , 0.0f ,
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);
        //缓存点位
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexArray.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertex = vbb.asFloatBuffer();
        vertex.put(vertexArray);
        vertex.position(0);

        gl.glColor4f(1.0f,0.0f,0.0f,1.0f);
        gl.glPointSize(8);
        gl.glLoadIdentity();
        gl.glTranslatef(0,0,-4);

        //开关点管道
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3,GL10.GL_FLOAT,0,vertex);
        gl.glDrawArrays(GL10.GL_POINTS,0,3);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
