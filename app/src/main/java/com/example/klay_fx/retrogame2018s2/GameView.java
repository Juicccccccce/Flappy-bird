package com.example.klay_fx.retrogame2018s2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/***
 * This class is created by Yutong Wang on 16/10/2018.
 */

public class GameView extends View implements View.OnTouchListener, Runnable{

    public static final int DELAY_TIME = 120;

    Paint p;
    Game game;

    // use the observer design pattern here.
    ArrayList<GameOver> observer;
    Handler repaintHandler;

    public static Bitmap birdImg;
    public static Bitmap pillarImg;
    public static Bitmap pillarImgReversed;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        p = new Paint();

        //set up bitmap
        birdImg = BitmapFactory.decodeResource(getResources(), R.drawable.bird);
        this.setOnTouchListener(this);
        observer = new ArrayList<>();
        game = new Game();

        pillarImg = BitmapFactory.decodeResource(getResources(), R.drawable.pipe);
        pillarImgReversed = BitmapFactory.decodeResource(getResources(), R.drawable.pipereversed);

        repaintHandler = new Handler();
        repaintHandler.postDelayed(this, DELAY_TIME);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        game.draw(canvas, p);
    }

    public boolean step() {
        game.step();
        if(game.isBirdHit()) {
            showGameOver();
            return false;
        } // not ending
        this.invalidate();
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            for(int i = 0; i < 7; i++) {
                game.birdFly(); // bird moves up
                this.invalidate();

            }
        }
        return true;
    }

    private void showGameOver() {
        for(GameOver o : observer) {
            o.gameOver();
        }
    }

    // register gameover
    public void registerGameOver(GameOver gameOver) {
        observer.add(gameOver);
    }

    @Override
    public void run() {
        if(step()) {
            repaintHandler.postDelayed(this, DELAY_TIME);
        }
    }
}
