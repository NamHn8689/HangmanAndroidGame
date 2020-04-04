package com.example.hangmanandroidgame;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends Activity implements View.OnClickListener {
    String s = "";

    String input;
    ImageView imageView;
    TextView tvQs;
    TextView tvAns;
    String question = "Guess the Programming Language ?";
    String answer = "javascript";
    char[] answerToCharArr = answer.toCharArray();
//    ArrayList<QA> listQA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.imgHang);
        tvQs = findViewById(R.id.tvQs);
        tvAns = findViewById(R.id.tvAns);

        for (int i = 0; i < answer.length(); i++) {
            s += "_";
        }

        tvQs.setText(question);
        tvAns.setText(s);

        //32button
        int[] idButton = {R.id.btnA, R.id.btnB, R.id.btnC, R.id.btnD, R.id.btnE, R.id.btnF, R.id.btnG, R.id.btnH,
                R.id.btnI, R.id.btnJ, R.id.btnK, R.id.btnL, R.id.btnM, R.id.btnN, R.id.btnO, R.id.btnP, R.id.btnQ, R.id.btnR,
                R.id.btnS, R.id.btnT, R.id.btnU, R.id.btnV, R.id.btnW, R.id.btnX, R.id.btnY, R.id.btnZ};
        for (int id : idButton) {
            View v = findViewById(id);
            v.setOnClickListener(this);
        }


    }

    public void onClick(View v) {
        input = ((Button) v).getText().toString();
        if (check())
            updateAnsText();
        else
            updateImg();

    }

    public boolean check() {
        if (answer.indexOf(input) != -1)
            return true;
        else return false;
    }

    public void updateAnsText() {
        String[] ansArr = answer.split("");
        String[] sArr = s.split("");
        for (int i = 0; i <= answer.length(); i++)
            if (ansArr[i].equals(input)){
                sArr[i] = input;
            }
        System.out.println(sArr[3]);
        s="";
        for(String i:sArr){
            s += i;
        }
        tvAns.setText(s);
    }

    public void updateImg() {

    }
}
