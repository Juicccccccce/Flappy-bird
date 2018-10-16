package com.example.klay_fx.retrogame2018s2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;


/**
 * @author Xuan Feng, Xinli Xu
 */
public class Bird extends Item {
    float x;
    float y;

    float width;
    float height;

    public float gravity_acc = 0.0005f;
    Bitmap b;


    public Bird(float x, float y, Bitmap b) {
        this.x = x;
        this.y = y;
        this.b = b;

        width = 0.1f;
        height = 0.05f;
    }

    // draw the Bird
    public void draw(Canvas c , Paint p) {
        float cw = c.getWidth();
        float ch = c.getHeight();

        b = Bitmap.createScaledBitmap(b, (int) (width * cw), (int) (height * ch), true);
        c.drawBitmap(b, x * cw, y * ch,p);
    }

    public void step(){
        // TODO: 2018/10/15
        y += Game.BIRD_STEP + gravity_acc;
        gravity_acc += 0.005;
    }


    public boolean hitBy(Pillars pi){
        // TODO: 2018/10/15
        for (Pillar m : pi) {
            if (m.pos.distance(this.pos) < 1.0f/30.0f) return true;
        }
        return false;
    }
}
