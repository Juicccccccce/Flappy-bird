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

        Bitmap moving_bird = BitmapFactory.decodeResource(getResources(),R.drawable.bird);
        ImageView iv = findViewById(R.id.imageview);
        Canvas c = new Canvas();
        moving_bird = Bitmap.createScaledBitmap(moving_bird, 100, 80, true);
        Paint p = new Paint();
        c.drawBitmap(moving_bird,50.0f,50.0f,p);

//        Paint p = new Paint();
//        Canvas c =new Canvas();
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bird);
//        bitmap = Bitmap.createScaledBitmap(bitmap, (int) (0.1*c.getWidth()), (int) (0.05 * c.getHeight()), true);
//        c.drawBitmap(bitmap,50,50,p);
        iv.setImageBitmap(moving_bird);
//        Entry_View entry = findViewById(R.id.entry_view);
//        game = gameView.game; //?
//        gameView.registerGameOver(this);
    }



    public void playGame(View view) {
        Log.d("game", "button clicked");

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
