package com.example.klay_fx.retrogame2018s2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


/**
 * @author Xuan Feng
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showRank(View view) {
        Intent intent_rank = new Intent(this,RankActivity.class);
        startActivity(intent_rank);
    }


    public void playGame(View view) {
        Log.d("game", "button clicked");

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
