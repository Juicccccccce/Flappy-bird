package com.example.klay_fx.retrogame2018s2;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void hitby_isCorrect() {
        //meet first if
        Bird b_1 = new Bird(new Pos(0.38f,0.38f));
        Pillar p_1 = new Pillar(new Pos(0.5f,0.5f));
        Pillars p1 = new Pillars();
        p1.add(p_1);
        assertEquals("should be hitted by top pipe, but survive",true,b_1.hitBy(p1));
        //meet second if, hit by bottom pipe
        Bird b_2 = new Bird(new Pos(0.45f,0.8f));
        Pillar p_2 = new Pillar(new Pos(0.45f,0.8f));
        Pillars p2 = new Pillars();
        p2.add(p_2);
        assertEquals("should be hitted by bottom pipe, but survive",true, b_2.hitBy(p2));
        //meet second if, hit by flower
        Flower f1 = new Flower(new Pos(0.5f,0.4f));
        Bird b_3 = new Bird(new Pos(0.35f,0.4f));
        assertEquals("should be hitted by flower, but survive",true,b_3.hitBy(p2));
        //meet third if,hit by ground
        Bird b_4 = new Bird(new Pos(0.28f,0.8f));
        assertEquals("should be hitted by ground, but survive",true,b_4.hitBy(p2));
        //bird is not hitted by any, successfully hitted
        Bird b_5 = new Bird(new Pos(0.55f,0.4f));
        assertEquals("should not be hitted by anything, but dead",false,b_5.hitBy(p2));
    }

    @Test
    public void getPillar_isCorrect() {
        Pillar pi = new Pillar(new Pos(0.5f,0.5f));
        Pillars p = new Pillars();
        p.add(pi);
        p.getPillar();
        assertEquals("pillars' size should encrease one but not",2,p.size());
    }
}