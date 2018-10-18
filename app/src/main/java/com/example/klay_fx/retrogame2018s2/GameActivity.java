package com.example.klay_fx.retrogame2018s2;

import android.content.Intent;
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
import java.util.ArrayList;
import java.util.prefs.Preferences;

/**
 * @author Xuan Feng, Yutong Wang
 */
public class GameActivity extends AppCompatActivity implements GameOver {

    static TextView counter;
    RelativeLayout rl;
    static int dayOrNight = 1;
    GameView gameView;
    Game game; //?
    private boolean isPause = false;

    ImageView scoreboard;
    ImageButton restart;
    ImageButton backToMenu;
    ImageButton pauseButton;
    static ImageView usage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        MainActivity.load();

        scoreboard = findViewById(R.id.imageView2);
        scoreboard.setVisibility(View.INVISIBLE);

        restart = findViewById(R.id.restart);
        restart.setVisibility(View.INVISIBLE);

        backToMenu = findViewById(R.id.backtomenu);
        backToMenu.setVisibility(View.INVISIBLE);

        pauseButton = findViewById(R.id.pause);

        usage = findViewById(R.id.usage);


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


    @Override
    public void gameOver() {
//        Toast.makeText(getApplicationContext(), "GAME OVER", Toast.LENGTH_SHORT).show();
        System.out.println("hi");
        MainActivity.save();
        scoreboard.setVisibility(View.VISIBLE);
        restart.setVisibility(View.VISIBLE);
        backToMenu.setVisibility(View.VISIBLE);


//        gameView.repaintHandler.removeCallbacks(gameView);

    }

    /**
     * Handle the pause button click to pause and continue the game.
     * @param view
     */
    public void pauseGame(View view) {

        if(!isPause) {
            isPause = true;
            pauseButton.setImageResource(R.drawable.resume);
            gameView.repaintHandler.removeCallbacks(gameView);
        } else {
            isPause = false;
            pauseButton.setImageResource(R.drawable.pauce);
            gameView.repaintHandler.postDelayed(gameView, 100);
        }
    }

    /**
     * 1) Handle the restart button click to restart the game
     * 2) Handle the backToMenu button click to back to the previous activity
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.restart:
                // TODO: RESTART FUNCTION
                Intent intent_restart = new Intent(this,GameActivity.class);
                finish();
                startActivity(intent_restart);
                break;
            case R.id.backtomenu:
                setResult(RESULT_OK);
                finish();
                break;
        }
    }

}
