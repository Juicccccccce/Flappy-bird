package com.example.klay_fx.retrogame2018s2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

/**
 * @author Xuan Feng
 */
public class GameActivity extends AppCompatActivity implements GameOver {

    static TextView counter;
    RelativeLayout rl;
    static int dayOrNight = 1;
    GameView gameView;
    Game game; //?
    private ImageButton pause;
    private boolean isPause = false;

    ImageView scoreboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ImageView scoreboard = findViewById(R.id.imageView2);
        scoreboard.setVisibility(View.INVISIBLE);

        pause = findViewById(R.id.imageButton3);

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
        Toast.makeText(getApplicationContext(), "GAME OVER", Toast.LENGTH_SHORT).show();
//        scoreboard.setVisibility(View.VISIBLE);
        setResult(RESULT_OK);
        finish();
    }

    public void pauseGame(View view) {
//        if(Game.isPause == false) {
//            Game.isPause = true;
//        }
        if(!isPause) {
            isPause = true;
            gameView.repaintHandler.removeCallbacks(gameView);
        } else {
            isPause = false;
            gameView.repaintHandler.postDelayed(gameView, 100);
        }
    }
}
