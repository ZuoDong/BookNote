package com.administrator.opengles.activity;

import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.administrator.opengles.OpenGLRenderer;
import com.administrator.opengles.mode.SimplePlane;

public class OpenGlSquareActivity extends AppCompatActivity {

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); // (NEW)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); // (NEW)

        GLSurfaceView view = new GLSurfaceView(this);
        OpenGLRenderer renderer = new OpenGLRenderer();
        view.setRenderer(renderer);
        setContentView(view);

    }
}
