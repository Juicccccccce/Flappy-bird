package com.example.klay_fx.retrogame2018s2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;


/**
 * @author Xuan Feng, Xinli Xu
 */
public class Bird extends Item {

    float width;
    float height;

    public float gravity_acc = 0.0005f;
    Bitmap b;


    public Bird(Pos p, Bitmap b) {
        this.b = b;
        pos = p;
        width = 0.1f;
        height = 0.05f;
    }

    // draw the Bird
    public void draw(Canvas c , Paint p) {
        float cw = c.getWidth();
        float ch = c.getHeight();

        b = Bitmap.createScaledBitmap(b, (int) (width * cw), (int) (height * ch), true);
        c.drawBitmap(b, pos.x * cw, pos.y * ch,p);
    }

    public void step(){
        pos.y += Game.BIRD_STEP + gravity_acc;
        gravity_acc += 0.005;
    }


    /**
     *
     * @function to check whether the bird hits pillars or the ground
     */
    public boolean hitBy(Pillars pi){
        for (Pillar m : pi) {
            float left = m.pos.x - Pillar.PILLARWIDTH/2;
            float right = m.pos.x + Pillar.PILLARWIDTH/2;
            float whiteTop = m.pos.y - 0.115f;
            float whiteBottom = m.pos.y + 0.115f;

            float birdRight = pos.x + width;
            float birdLeft = pos.x ;
            float birdTop = pos.y ;
            float birdBottom = pos.y + height;

            if (birdRight >= left && birdLeft <= right && birdTop <= whiteTop ){
                return true;
            }//hit top pipe
            if (birdRight >= left && birdLeft <= right && birdBottom >= whiteBottom){
                return true;
            }//hit bottom pipe
            if (birdBottom >= (5.5f / 7.0f) ) {return true;}// hit ground
        }
        return false;
    }
}
