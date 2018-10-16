package com.example.klay_fx.retrogame2018s2;

import android.graphics.Canvas;
import android.graphics.Paint;


/**
 * @author Xuan Feng
 */
public class Pillar extends Item {
    public static final float PILLARWIDTH = (1.0f / 20.0f);
    public static final float WHITETOP = (1.0f / 3.0f);
    public static final float WHITEBOTTOM = (2.0f / 3.0f);

    public Pillar(Pos p) {
        pos = new Pos(p);
    }

    // draw the Pillar
    public void draw(Canvas c , Paint p) {
        int w = c.getWidth();
        int h = c.getHeight();

        float xc = pos.x * w;
        float left = xc + PILLARWIDTH/2;
        float right = xc + PILLARWIDTH/2;
        float whitetop = WHITETOP * h;
        float whitebottom = WHITEBOTTOM * h;
        c.drawRect(left,0.0f,right,whitetop,p);
        c.drawRect(left,0.0f,right,whitebottom,p);
    }
}
