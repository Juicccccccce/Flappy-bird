package com.example.klay_fx.retrogame2018s2;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


/**
 * @author Xuan Feng
 */
public class Pillars extends ArrayList<Pillar> {

    // TODO: how to generate the pillars continuously
    Pillars(){

    }

    public static final float WHITETOP = (1.0f / 3.0f);
    public static final float PILLARSTEP = 0.03f;

    public void step() {
        for (Pillar b : this) b.pos.x -= PILLARSTEP;
        Iterator<Pillar> bi = this.iterator();
        while (bi.hasNext()) {
            Pillar b = bi.next();
            if (b.pos.x > Game.MAXXY) bi.remove();
        }
    }

    public void getPillar(){
        Random r = new Random();
        float y = r.nextFloat()/3 + WHITETOP ;

        this.add(new Pillar(new Pos(1.0f,y)));
    }

    public void draw(Canvas canvas, Paint paint) {
        for (Pillar b : this) b.draw(canvas, paint);
    }
}
