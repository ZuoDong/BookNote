package com.administrator.opengles;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer implements GLSurfaceView.Renderer {


 private Square square;

 public void onDrawFrame(GL10 gl) {
 // Clears the screen and depth buffer. 清理屏幕和缓冲
 gl.glClear(GL10.GL_COLOR_BUFFER_BIT | // OpenGL docs.
 GL10.GL_DEPTH_BUFFER_BIT);

  gl.glLoadIdentity(); // Replace the current matrix with the identity matrix
  gl.glTranslatef(0, 0, -4); // Translates 4 units into the screen.
  // Draw our square.
  square.draw(gl); // ( NEW )

 }


 @Override
 public void onSurfaceCreated(GL10 gl, javax.microedition.khronos.egl.EGLConfig config) {
  // Set the background color to black ( rgba ).
  gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);  // OpenGL docs.
  // Enable Smooth Shading, default not really needed.
  gl.glShadeModel(GL10.GL_SMOOTH);// OpenGL docs.
  // Depth buffer setup.
  gl.glClearDepthf(1.0f);// OpenGL docs.
  // Enables depth testing.
  gl.glEnable(GL10.GL_DEPTH_TEST);// OpenGL docs.
  // The type of depth testing to do.
  gl.glDepthFunc(GL10.GL_LEQUAL);// OpenGL docs.
  // Really nice perspective calculations.
  gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, // OpenGL docs.
          GL10.GL_NICEST);

  // Initialize our square.
  square = new Square();
 }

 public void onSurfaceChanged(GL10 gl, int width, int height) {
 // Sets the current view port to the new size.
 gl.glViewport(0, 0, width, height);// OpenGL docs.
 // Select the projection matrix
 gl.glMatrixMode(GL10.GL_PROJECTION);// OpenGL docs.
 // Reset the projection matrix
 gl.glLoadIdentity();// OpenGL docs.
 // Calculate the aspect ratio of the window
 GLU.gluPerspective(gl, 45.0f,
 (float) width / (float) height,
 0.1f, 100.0f);
 // Select the modelview matrix
 gl.glMatrixMode(GL10.GL_MODELVIEW);// OpenGL docs.
 // Reset the modelview matrix
 gl.glLoadIdentity();// OpenGL docs.
 }
}