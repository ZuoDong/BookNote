package com.zuodong.androiddesignpatterns.ChapterEleven;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by dongdong on 2017/3/7.
 *
 * 绘制的真正执行者
 */

public class DrawCanvas extends SurfaceView implements SurfaceHolder.Callback{

    public boolean isDrawing,isRunning;//标识是否可以绘制，绘制线程是否可以运行

    private Bitmap mBitmap;//绘制到的位图对象
    private DrawInvoker mInvoker;//绘制命令请求对象
    private DrawThread mDrawThread;//绘制线程

    public DrawCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);

        mInvoker = new DrawInvoker();
        mDrawThread = new DrawThread();

        getHolder().addCallback(this);
    }

    public void add(DrawPath path){
        mInvoker.add(path);
    }

    public void undo(){
        isDrawing = true;
        mInvoker.undo();
    }

    public void redo(){
        isDrawing = true;
        mInvoker.redo();
    }

    public boolean canUndo(){
        return mInvoker.canUndo();
    }

    public boolean canRedo(){
        return mInvoker.canRedo();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isRunning = true;
        mDrawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        mBitmap = Bitmap.createBitmap(width,height, Bitmap.Config.RGB_565);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        isRunning = false;
        while (retry){
            try {
                mDrawThread.join();//等待主线程执行完毕，然后执行
                retry = false;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    private class DrawThread extends Thread{
        @Override
        public void run() {
            Canvas canvas = null;
            while (isRunning){
                if(isDrawing){
                    try {
                        canvas = getHolder().lockCanvas(null);
                        if(mBitmap == null){
                            mBitmap = Bitmap.createBitmap(1,1, Bitmap.Config.ARGB_8888);
                        }
                        Canvas c = new Canvas(mBitmap);
                        c.drawColor(0, PorterDuff.Mode.CLEAR);

                        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        mInvoker.execute(c);
                        canvas.drawBitmap(mBitmap,0,0,null);
                    }finally {
                        getHolder().unlockCanvasAndPost(canvas);
                    }
                }
                isDrawing = false;
            }
        }
    }
}
