package com.example.klay_fx.retrogame2018s2;

import android.content.Context;
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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.prefs.Preferences;


/**
 * @author Xuan Feng
 */
public class MainActivity extends AppCompatActivity {

    static Preferences prefs = Preferences.userNodeForPackage(Game.class);
    public static ArrayList<Integer> scoreList = new ArrayList<>();
    public static int[] score = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

//    public void showRank(View view) {
//        Intent intent_rank = new Intent(this,RankActivity.class);
//        startActivity(intent_rank);
//    }


    public void playGame(View view) {
        Log.d("game", "button clicked");
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void viewRank(View view) {
        load();
        Intent intent = new Intent(this, RankActivity.class);
        startActivity(intent);
    }

    public void load() {
        //reading text from file
        try {
            FileInputStream fileIn=openFileInput("sayhiiii.txt");
            InputStreamReader inputRead= new InputStreamReader(fileIn);

            BufferedReader bufferedReader = new BufferedReader(inputRead);
//            StringBuilder sb = new StringBuilder();
            String line;
            int max1 = 0;
            int max2 = 0;
            int max3 = 0;
            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println("------------------->!!!----->" + line);
                int x = Integer.parseInt(line);
                if(x >= max1) {
                    System.out.println(x + ">=" + max1);
                    max1 = x;
                } else if(x >= max2) {
                    System.out.println(x + ">=" + max2);
                    max2 = x;
                } else if(x >= max3) {
                    System.out.println(x + ">=" + max3);
                    max3 = x;
                }
            }

            score[0] = max1;
            score[1] = max2;
            score[2] = max3;

            inputRead.close();
//            score[0] = sb.toString();
//            System.out.println("=====================" + score[0] + "=======================");

//                System.out.println("=====================" + score[1] + "=======================");

//                System.out.println("=====================" + score[2] + "=======================");

//            textmsg.setText(s);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save(){
        scoreList.add(Game.counter);
        Collections.sort(scoreList);
        if (scoreList.size()>3){
            scoreList.remove(0);
        }

        for (Integer i : scoreList) {
            System.out.println(i);
        }

        if (scoreList.size()==1) {
            prefs.putInt("1", scoreList.get(0));
            prefs.putInt("2",0);
            prefs.putInt("3",0);
        } else if (scoreList.size()==2){
            prefs.putInt("1", scoreList.get(1));
            prefs.putInt("2", scoreList.get(0));
            prefs.putInt("3",0);
        } else if (scoreList.size()==3){
            prefs.putInt("1", scoreList.get(2));
            prefs.putInt("2", scoreList.get(1));
            prefs.putInt("3", scoreList.get(0));
        }
    }

//    public static void load(){
//        int int1 = prefs.getInt("1",0);
//        int int2 = prefs.getInt("2",0);
//        int int3 = prefs.getInt("3",0);
//        if (scoreList.size()!=3){
//            scoreList.add(int1);
//            scoreList.add(int2);
//            scoreList.add(int3);
//        } else {
//            scoreList.clear();
//            scoreList.add(int1);
//            scoreList.add(int2);
//            scoreList.add(int3);
//
//        }
//
//        for (Integer i : scoreList) {
//            System.out.println(i);
//        }
//    }
}
