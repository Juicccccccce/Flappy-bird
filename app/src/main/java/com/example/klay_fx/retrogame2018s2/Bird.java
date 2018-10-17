package com.example.klay_fx.retrogame2018s2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;


/**
 * @author Xuan Feng, Xinli Xu, Yutong Wang.
 */
public class Bird extends Item {

    private float width;
    private float height;

    public static float gravity_acc = 0.0055f;
    public static float v = 0.02f;

    private Bitmap b1;
    private Bitmap b2;
    private Bitmap b3;

    private int bird_state;


    public Bird(Pos p) {
        this.b1 = GameView.birdImg1;
        this.b2 = GameView.birdImg2;
        this.b3 = GameView.birdImg3;
        pos = p;
        width = 0.1f;
        height = 0.05f;
        bird_state = 0;
    }

    // draw the Bird
    public void draw(Canvas c , Paint p) {
        float cw = c.getWidth();
        float ch = c.getHeight();

        if(bird_state == 0) {
            b1 = Bitmap.createScaledBitmap(b1, (int) (width * cw), (int) (height * ch), true);
            c.drawBitmap(b1, pos.x * cw, pos.y * ch, p);
            bird_state = 1;
        } else if (bird_state == 1){
            b2 = Bitmap.createScaledBitmap(b2, (int) (width * cw), (int) (height * ch), true);
            c.drawBitmap(b2, pos.x * cw, pos.y * ch, p);
            bird_state = 2;
        } else {
            b3 = Bitmap.createScaledBitmap(b3, (int) (width * cw), (int) (height * ch), true);
            c.drawBitmap(b3, pos.x * cw, pos.y * ch, p);
            bird_state = 0;
        }
    }

    public void step(){
        v += gravity_acc;
        pos.y += v;

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
