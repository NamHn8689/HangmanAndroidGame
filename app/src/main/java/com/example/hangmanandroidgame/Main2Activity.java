package com.example.hangmanandroidgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends Activity implements View.OnClickListener {
    ImageView imageView;
    TextView tvQs;
    TextView tvAns;
    String question ="Guess the Programming Language ?";

    ArrayList<QA> listQA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //32button
        int[] idButton = {R.id.btnA, R.id.btnB, R.id.btnC, R.id.btnD, R.id.btnE, R.id.btnF, R.id.btnG, R.id.btnH,
                R.id.btnI, R.id.btnJ, R.id.btnK, R.id.btnL, R.id.btnM, R.id.btnN, R.id.btnO, R.id.btnP, R.id.btnQ, R.id.btnR,
                R.id.btnS, R.id.btnT, R.id.btnU, R.id.btnV, R.id.btnW, R.id.btnX, R.id.btnY, R.id.btnZ};
        for (int id : idButton) {
            View v = findViewById(id);
            v.setOnClickListener(this);
        }

        imageView = findViewById(R.id.imgHang);
        tvQs = findViewById(R.id.tvQs);
        tvAns = findViewById(R.id.tvAns);

        listQA = new ArrayList<>();
        listQA.add(new QA("Guess the Programming Language","java"));
        listQA.add(new QA("Guess the Programming Language","javascript"));
        listQA.add(new QA("Guess the Programming Language","kotlin"));
        listQA.add(new QA("Guess the Programming Language","python"));
        listQA.add(new QA("Guess the Programming Language","c"));
        listQA.add(new QA("Guess the Programming Language","ruby"));
        listQA.add(new QA("Guess the Programming Language","golang"));
        listQA.add(new QA("Guess the Programming Language","php"));
        listQA.add(new QA("Guess the Programming Language","dart"));
        listQA.add(new QA("Guess the Programming Language","typescript"));
        listQA.add(new QA("Guess the Programming Language","csharp"));

        tvQs.setText(question);

    }
    public void onClick(View v) {
        v.getId();
    }
}
