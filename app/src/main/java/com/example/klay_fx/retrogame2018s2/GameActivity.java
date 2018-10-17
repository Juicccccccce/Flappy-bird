package com.example.klay_fx.retrogame2018s2;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author Xuan Feng
 */
public class GameActivity extends AppCompatActivity implements GameOver {

    static TextView counter;
    RelativeLayout rl;
    static int dayOrNight = 1;
    GameView gameView;
    Game game; //?

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        rl = findViewById(R.id.rootRL);
        if (dayOrNight == 1) {
            rl.setBackgroundResource(R.drawable.background1);
            dayOrNight --;
        } else {
            rl.setBackgroundResource(R.drawable.background2);
            dayOrNight ++;
        }

//        add a textview to show a counter
        counter = findViewById(R.id.counter);
        counter.setTextColor(Color.WHITE);
        Game.counter = 0;
        gameView = findViewById(R.id.gameview);
        game = gameView.game; //?
        gameView.registerGameOver(this);
    }

//    final ImageView backgroundOne = (ImageView) findViewById(R.id.ground_One);
//    final ImageView backgroundTwo = (ImageView) findViewById(R.id.ground_Two);
//
//    final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
//    animator.setRepeatCount(ValueAnimator.INFINITE);
//    animator.setInterpolator(new LinearInterpolator());
//    animator.setDuration(10000L);
//    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//        @Override
//        public void onAnimationUpdate(ValueAnimator animation) {
//            final float progress = (float) animation.getAnimatedValue();
//            final float width = backgroundOne.getWidth();
//            final float translationX = width * progress;
//            backgroundOne.setTranslationX(translationX);
//            backgroundTwo.setTranslationX(translationX - width);
//        }
//    });
//animator.start();

    @Override
    public void gameOver() {
        setResult(RESULT_OK);
        finish();
    }

}
