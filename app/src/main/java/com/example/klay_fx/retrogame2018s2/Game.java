package com.example.klay_fx.retrogame2018s2;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Game - this is the model of the main game.
 *
 * @author Xuan Feng
 */

public class Game {
    public static final float MAXXY = 1.0f;
    public static final float MINXY = 0.0f;

    //starting position of bird
    public static final float BIRD_X = 0.4f; //?
    public static final float BIRD_Y = 0.5f;

    public static final float BIRD_STEP = 0.02f;
    public static int counter = 0;



    //Entities in the game
    private Bird bird;
    private Pillars pillars;
    private Pos birdStart = new Pos(BIRD_X,BIRD_Y);

    private boolean birdHit;

    public Game(){
        bird = new Bird(birdStart, GameView.birdImg);
        pillars = new Pillars(); //what input ?
        birdHit = false;
    }

    /**
     * Draw all the entities
     */
    public void draw(Canvas c, Paint p) {
        pillars.draw(c, p); // param?
        bird.draw(c, p); //what parameter?
    }

    /**
     * @function checks whether the game ends, whether a new pillar need to be generated
     * and makes the items move.
     */
    public void step() {
        if(bird.hitBy(pillars)) {
            birdHit = true;
        } //multi lives?
        pillars.step();
        if (pillars.size() == 0) {
            pillars.getPillar();
        }
        else if (pillars.size() == 1 && pillars.get(0).pos.x < bird.pos.x) {
            pillars.getPillar();
            counter ++;
        }
        bird.step();
    }

    /**
     * Return true if bird is dead.
     */
    public boolean isBirdHit() { //multi lives?
        return birdHit;
    }

    // the game is endless?
    public boolean hasWon() {
        return true;
    }

    public void birdFly() {
        bird.pos.y -= BIRD_STEP;
        bird.gravity_acc = 0.0005f;
    }
}
