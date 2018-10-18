package com.example.klay_fx.retrogame2018s2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.os.Handler;


public class Entry_View extends View implements Runnable{
        Handler timer;
        int y = 0;
        int x = 0;
        Entry_View entryView;
        Canvas c = new Canvas();

    public Entry_View(Context context, @Nullable AttributeSet attr) {
        super(context);
        timer = new Handler();
        timer.postDelayed(this,10);
    }

    //2/5 to 3/5

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap moving_bird = BitmapFactory.decodeResource(getResources(),R.drawable.bird);
        moving_bird = Bitmap.createScaledBitmap(moving_bird, 100, 80, true);
        Paint p = new Paint();
        canvas.drawBitmap(moving_bird,canvas.getWidth()/2,2*canvas.getHeight()/5+100.0f*y,p);
        this.invalidate();
    }

    @Override
    public void run() {
        if (2*c.getHeight()/5+100.0f*y+100.0*x>=3*c.getHeight()/5) {
            y = 0;
            x ++;
        } else if (2*c.getHeight()/5+100.0f*y+100.0*x<=2*c.getHeight()/5) {
            y++;
            x = 0;
        }
        this.invalidate();
        timer.postDelayed(this,10);
    }
}
