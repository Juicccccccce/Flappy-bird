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

    float width;
    float height;

    public float i = 0.0005f;
<<<<<<< HEAD
=======
    int v;
>>>>>>> 7596d6644f048f661dce8e9d5bd1c2f28974756e
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
        y += Game.BIRD_STEP + i;
        i += 0.0002;
<<<<<<< HEAD
        System.out.println(i);
=======
//            this.pos.y += 5*speed*i;
//            i = i +1;
//            speed = i * speed;
>>>>>>> 7596d6644f048f661dce8e9d5bd1c2f28974756e
    }


    public boolean hitBy(Pillars pi){
        // TODO: 2018/10/15
        for (Pillar m : pi) {
            if (m.pos.distance(this.pos) < 1.0f/30.0f) return true;
        }
        return false;
    }
}
