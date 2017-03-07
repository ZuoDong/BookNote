package com.zuodong.androiddesignpatterns.ChapterEleven;

import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.zuodong.androiddesignpatterns.R;

public class DrawActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawCanvas draw_canvas;//绘制画布
    private DrawPath drawPath;//路径绘制命令
    private Paint paint;//画笔
    private IBrush iBrush;//笔触


    private Button red_btn;
    private Button green_btn;
    private Button blue_btn;
    private Button normal_btn;
    private Button circle_btn;
    private Button undo_btn; //重做
    private Button redo_btn; //撤销

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_draw);
        initView();
    }

    private void initView() {
        draw_canvas = (DrawCanvas) findViewById(R.id.draw_canvas);
        red_btn = (Button) findViewById(R.id.red_btn);
        green_btn = (Button) findViewById(R.id.green_btn);
        blue_btn = (Button) findViewById(R.id.blue_btn);
        normal_btn = (Button) findViewById(R.id.normal_btn);
        circle_btn = (Button) findViewById(R.id.circle_btn);
        undo_btn = (Button) findViewById(R.id.undo_btn);
        redo_btn = (Button) findViewById(R.id.redo_btn);

        red_btn.setOnClickListener(this);
        green_btn.setOnClickListener(this);
        blue_btn.setOnClickListener(this);
        normal_btn.setOnClickListener(this);
        circle_btn.setOnClickListener(this);
        undo_btn.setOnClickListener(this);
        redo_btn.setOnClickListener(this);
        undo_btn.setEnabled(false);
        redo_btn.setEnabled(false);
        draw_canvas.setOnTouchListener(new DrawTouchListener());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.red_btn: //红色
                paint = new Paint();
                paint.setStrokeWidth(3);
                paint.setColor(0xffff0000);
                break;
            case R.id.green_btn:
                paint = new Paint();
                paint.setStrokeWidth(3);
                paint.setColor(0xff00ff00);
                break;
            case R.id.blue_btn:
                paint = new Paint();
                paint.setStrokeWidth(3);
                paint.setColor(0xff0000ff);
                break;
            case R.id.normal_btn:
                iBrush = new NormalBrush();
                break;
            case R.id.circle_btn:
                iBrush = new CircleBrush();
                break;
            case R.id.undo_btn:
                draw_canvas.undo();
                if(!draw_canvas.canUndo()){
                    undo_btn.setEnabled(false);
                }
                undo_btn.setEnabled(true);
                break;
            case R.id.redo_btn:
                draw_canvas.redo();
                if(!draw_canvas.canRedo()){
                    redo_btn.setEnabled(false);
                }
                redo_btn.setEnabled(true);
                break;
        }
    }

    private class DrawTouchListener implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                drawPath = new DrawPath();
                drawPath.paint = paint;
                drawPath.path = new Path();
                iBrush.down(drawPath.path,event.getX(),event.getY());
            }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                iBrush.move(drawPath.path,event.getX(),event.getY());
            }else if(event.getAction() == MotionEvent.ACTION_UP){
                iBrush.up(drawPath.path,event.getX(),event.getY());
                draw_canvas.add(drawPath);
                draw_canvas.isDrawing = true;
                undo_btn.setEnabled(true);
                redo_btn.setEnabled(false);
            }
            return true;
        }
    }
}
