package com.example.klay_fx.retrogame2018s2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;

public class Entry_View extends View{
        Canvas c =new Canvas();
        Entry_View entryView;

    public Entry_View(Context context) {
        super(context);

//        entryView = findViewById(R.id.entry);
//        Bitmap moving_bird = BitmapFactory.decodeResource(getResources(),R.drawable.bird);
//        ImageView iv = findViewById(R.id.imageview);
//        Canvas c = new Canvas();
//        moving_bird = Bitmap.createScaledBitmap(moving_bird, 100, 80, true);
//        Paint p = new Paint();
//        c.drawBitmap(moving_bird,50.0f,50.0f,p);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
}
