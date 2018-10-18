package com.example.klay_fx.retrogame2018s2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RankActivity extends AppCompatActivity {
    TextView rank1;
    TextView rank2;
    TextView rank3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        rank1 = findViewById(R.id.textView);
        rank2 = findViewById(R.id.textView2);
        rank3 = findViewById(R.id.textView3);
        Bespoke.load();
        if (Bespoke.scorelist.size() == 0){
            Bespoke.scorelist.add(0);
            Bespoke.scorelist.add(0);
            Bespoke.scorelist.add(0);
        }
        rank1.setText(String.valueOf(Bespoke.scorelist.get(0)));
        rank2.setText(String.valueOf(Bespoke.scorelist.get(1)));
        rank3.setText(String.valueOf(Bespoke.scorelist.get(2)));
    }


}
