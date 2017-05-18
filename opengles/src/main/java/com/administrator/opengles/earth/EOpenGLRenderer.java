package com.administrator.opengles.earth;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * 作者：zuo
 * 时间：2017/5/18:17:47
 */

public class EOpenGLRenderer implements GLSurfaceView.Renderer {

    private final IEOpenGLDemo mOpenGLDemo;

    public EOpenGLRenderer(IEOpenGLDemo openGLDemo) {
        this.mOpenGLDemo = openGLDemo;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.0f,0.0f,0.0f,0.5f);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glClearDepthf(1.0f);
        gl.glDepthFunc(GL10.GL_LEQUAL);//深度测试
        if(mOpenGLDemo != null){
            mOpenGLDemo.initLight(gl);
            mOpenGLDemo.initObject(gl);
        }
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0,0,width,height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl,45.0f,(float)width/(float)height,0.1f,100.0f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        if(mOpenGLDemo != null){
            mOpenGLDemo.DrawScene(gl);
        }
    }
}
