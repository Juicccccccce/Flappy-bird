package com.example.klay_fx.retrogame2018s2;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @author Xuan Feng,Yutong Wang
 */

public class FPillar extends Pillar {

    Pos pillarPos;
    Flower flower;

    public FPillar(Pos p) {
        super(p);
        pillarPos = pos;

        flower = new Flower(pos);

    }

    public void draw(Canvas c, Paint p) {
        super.draw(c, p);
//        flower.draw(c, p);
    }

    public void step() {
        super.step();
//        flower.step();
    }
}
