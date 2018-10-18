package com.example.klay_fx.retrogame2018s2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Bespoke {
    private static String FILENAME = "/students/u6105656/AndroidStudioProjects/RetroGame2018s2/app/Rank.txt";
    private static Integer score = Game.counter;
    static ArrayList<Integer> scorelist = new ArrayList<>();


    public static void save() {
        try {
            BufferedWriter b_writer = new BufferedWriter(new FileWriter(FILENAME));
         //   BufferedWriter b_writer = Files.newBufferedWriter(new File(FILENAME).toPath(), Charset.forName("US-ASCII"));
            if (score != null) {
                scorelist.add(score);
                Collections.sort(scorelist);
                scorelist.remove(0);
               // b_writer.write(scorelist.get(0));
                b_writer.write(10   );
                b_writer.write(scorelist.get(1));
                b_writer.write(scorelist.get(2));
            }
            b_writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> load() {
        try {
            BufferedReader b_reader = new BufferedReader(new FileReader(FILENAME));

            String score1 = b_reader.readLine();
            String[] s = score1.split(" ");
            scorelist.add(Integer.valueOf(s[0]));
            scorelist.add(Integer.valueOf(s[1]));
            scorelist.add(Integer.valueOf(s[2]));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return scorelist;
    }

}
