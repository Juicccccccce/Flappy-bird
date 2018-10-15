package com.example.klay_fx.retrogame2018s2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playGame(View view) {
        Log.d("game", "button clicked");

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
