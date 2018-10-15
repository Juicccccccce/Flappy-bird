package com.example.klay_fx.retrogame2018s2;

import android.graphics.Paint;
import android.graphics.Canvas;

public abstract class Item {
    Pos pos;

    public abstract void draw(Canvas c, Paint p);
}
