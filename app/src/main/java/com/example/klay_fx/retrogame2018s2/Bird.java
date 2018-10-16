package com.example.klay_fx.retrogame2018s2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;


/**
 * @author Xuan Feng, Xinli Xu
 */
public class Bird extends Item {
    float x;
    float y;
    int i = 1;
    int speed = 2;
    Bitmap b;


    public Bird(float x, float y, Bitmap b) {
       this.x = x;
       this.y = y;
       this.b = b;
    }

    // draw the Bird
    public void draw(Canvas c , Paint p) {
        c.drawBitmap(b, x, y,p);
    }

    public void step(boolean hit){
        // TODO: 2018/10/15
            this.pos.y += 5*speed*i;
            i = i +1;
            speed = i * speed;
    }

    public void birdFly() {
        y += Game.BIRD_STEP;
    }


    public boolean hitBy(Pillars pi){
        // TODO: 2018/10/15
        for (Pillar m : pi) {
            if (m.pos.distance(this.pos) < 1.0f/30.0f) return true;
        }
        return false;
    }
}
