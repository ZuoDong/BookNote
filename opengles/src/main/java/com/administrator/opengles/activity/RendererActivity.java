package com.administrator.opengles.activity;

import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.administrator.opengles.OpenGLRenderer2;
import com.administrator.opengles.R;
import com.administrator.opengles.mode.SimplePlane;

public class RendererActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Remove the title bar from the window.
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Make the windows into full screen mode.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Create a OpenGL view.
        GLSurfaceView view = new GLSurfaceView(this);

        // Creating and attaching the renderer.
        OpenGLRenderer2 renderer = new OpenGLRenderer2();
        view.setRenderer(renderer);
        setContentView(view);

        // Create a new plane.
        SimplePlane plane = new SimplePlane(1, 1);

        // Move and rotate the plane.
        plane.z = 1.7f;
        plane.rx = -65;

        // Load the texture.
        plane.loadBitmap(BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher));

        // Add the plane to the renderer.
        renderer.addMesh(plane);
    }
}
