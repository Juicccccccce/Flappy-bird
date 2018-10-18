package com.example.klay_fx.retrogame2018s2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bespoke {
    private static String FILENAME = "Rank.txt";
    private static Integer score = Game.counter;
    ArrayList<Integer> scorelist = new ArrayList<>();

//    void save() {
//        try {
//            BufferedWriter b_writer = new BufferedWriter(new FileWriter(FILENAME));
//            if (score != null) {
//                b_writer.write(score);
//                b_writer.newLine();
//            }
//            b_writer.close();
//        } catch (IOException e) {
//            System.err.format("IOException: %s%n",e);
//        }
//    }
//
//    static ArrayList<Integer> load() {
//        try {
//            BufferedReader b_reader = new BufferedReader(new FileReader(FILENAME));
//            int score1 = Character.getNumericValue(Integer.valueOf(b_reader.readLine()));
//        }
//        catch (IOException e) {
//
//        }
//    }
}
