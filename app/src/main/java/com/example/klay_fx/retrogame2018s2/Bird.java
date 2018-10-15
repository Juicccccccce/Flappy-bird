package com.example.klay_fx.retrogame2018s2;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Bird extends Item {
    public static final float STARTX= (1.0f / 2.0f);
    public static final float STARTY= (1.0f / 2.0f);

    public Bird() {
        pos = new Pos(STARTX,STARTY);
    }

    // draw the Bird
    public void draw(Canvas c , Paint p) {
        int w = c.getWidth();
        int h = c.getHeight();

        float xc = pos.x * w;
        float yc = pos.y * h;
//        c.drawBitmap();      draw the picture of the bird.
    }
}
