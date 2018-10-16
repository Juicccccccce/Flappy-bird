package com.example.klay_fx.retrogame2018s2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @author Xuan Feng
 */
public class GameActivity extends AppCompatActivity implements GameOver {

    GameView gameView;
    Game game; //?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

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
