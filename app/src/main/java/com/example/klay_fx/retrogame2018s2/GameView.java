package com.example.klay_fx.retrogame2018s2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

    public static final int DELAY_TIME = 100;

    Paint p;
    Game game;
    ArrayList<GameOver> observer;
    Handler repaintHandler;

    private static Bitmap myBird;
    private static Bitmap myPillar;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        p = new Paint();
        //set up bitmap
        myBird = BitmapFactory.decodeResource(getResources(), R.drawable.bird);

        this.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override
    public void run() {

    }
}
