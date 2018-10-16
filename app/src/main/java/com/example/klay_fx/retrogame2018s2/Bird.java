package com.example.klay_fx.retrogame2018s2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;


/**
 * @author Xuan Feng, Xinli Xu
 */
public class Bird extends Item {
    float x;
    float y;
    int i = 1;
    int speed = 2;
    Bitmap myImage;


    public Bird(float x, float y) {
       this.x = x;
       this.y = y;
    }

    // draw the Bird
    public void draw(Canvas c , Paint p) {
        int w = c.getWidth();
        int h = c.getHeight();
//        float xc = pos.x * w;
//        float yc = pos.y * h;
        myImage = BitmapFactory.decodeResource(getResources(),R.drawable.bird);
        c.drawBitmap(myImage,x,y);

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
