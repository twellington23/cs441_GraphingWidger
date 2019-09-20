package com.example.graphingwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

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
        Canvas canvas = holder.lockCanvas();

        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(Color.GRAY);

        canvas.drawLine(50,50,100,120, paint);
        holder.unlockCanvasAndPost(canvas);
    }
}
