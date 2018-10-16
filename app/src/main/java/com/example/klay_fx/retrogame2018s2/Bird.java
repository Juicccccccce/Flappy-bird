package com.example.klay_fx.retrogame2018s2;

import android.graphics.Canvas;
import android.graphics.Paint;


/**
 * @author Xuan Feng, Xinli Xu
 */
public class Bird extends Item {
    public static final float STARTX = (1.0f / 2.0f);
    public static final float STARTY = (1.0f / 2.0f);
    int i = 1;
    int speed = 2;


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

    public void step(boolean hit){
        // TODO: 2018/10/15
        if (hit) {
            this.pos.y = this.pos.y - (1.0f/7.0f);
            speed = 0;
            i = 1;
        } else {
            this.pos.y += 5*speed*i;
            i = i +1;
            speed = i * speed;
        }
    }

    public boolean hitBy(Pillars pi){
        // TODO: 2018/10/15
        for (Pillar m : pi) {
            if (m.pos.distance(this.pos) < 1.0f/30.0f) return true;
        }
        return false;
    }
}
