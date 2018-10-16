package com.example.klay_fx.retrogame2018s2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;


/**
 * @author Xuan Feng
 */
public class Pillar extends Item {
    public static final float PILLARWIDTH = (1.0f / 8.0f);
    Bitmap b;

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


        float whitetop = yc - 0.11f * h;
        float whitebottom = yc + 0.11f * h;


        p.setColor(Color.GREEN);
        c.drawRect(left,0.0f,right,whitetop,p);
        c.drawRect(left,whitebottom,right,h,p);
    }
}
