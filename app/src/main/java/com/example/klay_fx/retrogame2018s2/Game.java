package com.example.klay_fx.retrogame2018s2;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Game - this is the model of the main game.
 */

public class Game {
    public static final float MAXXY = 1.0f;
    public static final float MINXY = 0.0f;

    private Bird bird;
    private Pillars pillars;

    boolean birdHit;

    public Game(){
        bird = new Bird();
        pillars = new Pillars();

        birdHit = false;
    }

    public void draw(Canvas canvas, Paint paint) {
        pillars.draw(canvas, paint);
    }
}
