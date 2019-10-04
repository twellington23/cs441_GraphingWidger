package com.example.graphingwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.zip.CheckedOutputStream;

public class MySurface extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holder = null;
    private Paint paint = null;

    public MySurface(Context context) {
        super(context);
        holder = getHolder();
        paint = new Paint();
        paint.setColor(Color.BLACK);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        drawGraph();
    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        paint = null;

    }

    public void drawGraph() {
        holder = getHolder();
        holder.setFormat(PixelFormat.TRANSLUCENT);
        Canvas canvas = holder.lockCanvas();

        paint.setColor(Color.WHITE);
        canvas.drawLine(50,1500,50, 100, paint);
        canvas.drawLine(50, 1500, 1000, 1500, paint);

        canvas.drawLine(250, 1500, 250, 100, paint);
        canvas.drawLine(450, 1500,450, 100, paint);
        canvas.drawLine(650,1500, 650, 100, paint);
        canvas.drawLine(850, 1500, 850, 100, paint);

        canvas.drawLine(50, 300, 1000, 300, paint);
        canvas.drawLine(50, 500, 1000, 500, paint);
        canvas.drawLine(50, 700, 1000, 700, paint);
        canvas.drawLine(50, 900, 1000, 900, paint);
        canvas.drawLine(50, 1100, 1000, 1100, paint);
        canvas.drawLine(50, 1300, 1000, 1300, paint);

        holder.unlockCanvasAndPost(canvas);
    }

    public void chartLine(float rate) {
        holder = getHolder();
        holder.setFormat(PixelFormat.TRANSLUCENT);
        Canvas canvas = holder.lockCanvas();
        paint.setColor(Color.WHITE);
        float prevY;
        float temp;
        float p = rate/100;

        canvas.drawLine(50, 1500, 250, 1500 - (1400*p), paint);
        prevY = 1500 - (1400*p);

        canvas.drawLine(250, prevY, 450, prevY - ((1400+1400*p)*p), paint);
        temp = prevY - ((1400+1400*p)*p);
        prevY = temp;

        canvas.drawLine(450, prevY, 650, prevY - (1400+(1400+1400*p)*p), paint);
        temp = prevY - ((1400+(1400+1400*p)*p));
        prevY = temp;

        canvas.drawLine(650, prevY, 850, prevY - (1400+(1400+(1400+1400*p))*p), paint);
    }

}
