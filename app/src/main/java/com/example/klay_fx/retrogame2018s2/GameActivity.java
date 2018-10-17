package com.example.klay_fx.retrogame2018s2;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author Xuan Feng
 */
public class GameActivity extends AppCompatActivity implements GameOver {

    static TextView counter;
    GameView gameView;
    Game game; //?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
//        add a textview to show a counter
        counter = findViewById(R.id.counter);
        counter.setTextColor(Color.WHITE);
        Game.counter = 0;
        gameView = findViewById(R.id.gameview);
        game = gameView.game; //?
        gameView.registerGameOver(this);
    }

    @Override
    public void gameOver() {
        setResult(RESULT_OK);
        finish();
    }
}
