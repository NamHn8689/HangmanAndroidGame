package com.example.hangmanandroidgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class Main2Activity extends Activity implements View.OnClickListener {
    String s = "";
    String input;
    String question = "Guess the Programming Language ?";
    String answer = "javascript";
    int timeFalse = 0;

    ImageView mImgHang;
    ImageView mImgHangLose;
    TextView tvQs;
    TextView tvAns;
    TableLayout mLine1;
    TableLayout mLine2;
    TableLayout mLine3;
    Button mResetButton;


//    ArrayList<QA> listQA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mImgHang = findViewById(R.id.imgHang);
        mImgHangLose = findViewById(R.id.imgHangLose);

        mLine1 = findViewById(R.id.line1);
        mLine2 = findViewById(R.id.line2);
        mLine3 = findViewById(R.id.line3);

        tvQs = findViewById(R.id.tvQs);
        tvAns = findViewById(R.id.tvAns);

        mResetButton = findViewById(R.id.btnReset);


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
        return answer.indexOf(input) != -1;
    }

    public void updateAnsText() {
        String[] ansArr = answer.split("");
        String[] sArr = s.split("");
        for (int i = 0; i <= answer.length(); i++)
            if (ansArr[i].equals(input)) {
                sArr[i] = input;
            }
        System.out.println(sArr[3]);
        s = "";
        for (String i : sArr) {
            s += i;
        }
        tvAns.setText(s);
    }

    public void updateImg() {
        timeFalse++;
        mImgHang.setImageLevel(timeFalse);
        if (timeFalse == 6)
            whenLose();
    }

    public void whenLose() {
        mImgHangLose.setVisibility(View.VISIBLE);
        mResetButton.setVisibility(View.VISIBLE);
        tvQs.setVisibility(View.INVISIBLE);
        tvAns.setVisibility(View.INVISIBLE);
        mLine1.setVisibility(View.INVISIBLE);
        mLine2.setVisibility(View.INVISIBLE);
        mLine3.setVisibility(View.INVISIBLE);

    }
}
