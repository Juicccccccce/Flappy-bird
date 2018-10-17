package com.example.klay_fx.retrogame2018s2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.io.InputStream;
import java.util.Random;


/**
 * @author Xuan Feng
 */
public class Pillar extends Item {
    public static final float PILLARWIDTH = (1.0f / 8.0f);
    public static final float PILLARHEIGHT = 1.0f;

    Bitmap b1 = GameView.pillarImg;
    Bitmap b2 = GameView.pillarImgReversed;

    // TODO: 17/10/18 need bitmap 
    public Pillar(Pos p) {
        pos = new Pos(p);
    }

    // draw the Pillar
    public void draw(Canvas c , Paint p) {

        int w = c.getWidth();
        int h = c.getHeight();



        float xc = pos.x * w;
        float yc = pos.y * h ;
        float left = xc - PILLARWIDTH/2*w;
        float right = xc + PILLARWIDTH/2*w;


        float whitetop = yc - 0.115f * h;
        float whitebottom = yc + 0.115f * h;

        b1 = Bitmap.createScaledBitmap(b1, (int) (PILLARWIDTH * w), (int) (PILLARHEIGHT * h), true);
        c.drawBitmap(b1,left,whitetop - PILLARHEIGHT*h,p);

        b2 = Bitmap.createScaledBitmap(b2, (int) (PILLARWIDTH * w), (int) (PILLARHEIGHT * h), true);
        c.drawBitmap(b2,left,whitebottom,p);
    }
}
