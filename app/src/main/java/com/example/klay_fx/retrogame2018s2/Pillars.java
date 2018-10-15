package com.example.klay_fx.retrogame2018s2;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Iterator;

public class Pillars extends ArrayList<Pillar> {

    public static final float PILLARSTEP = 0.03f;

    public void step() {
        for (Pillar b : this) b.pos.x += PILLARSTEP;
        Iterator<Pillar> bi = this.iterator();
        while (bi.hasNext()) {
            Pillar b = bi.next();
            if (b.pos.x > Game.MAXXY) bi.remove();
        }
    }

    public void draw(Canvas canvas, Paint paint) {
        for (Pillar b : this) b.draw(canvas, paint);
    }
}
