package com.example.hangmanandroidgame;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Main2Activity extends Activity implements View.OnClickListener {
    String s = "";
    String input;
    String question;
    //    String question = "Guess the Programming Language ?";
    String answer;
    //    String answer = "javascript";
    int level = 1;
    int timeFalse = 0;
    ArrayList<QA> listQA;

    DatabaseReference myRef;

    private ImageView mImgHang;
    private ImageView mImgHangLose;
    private TextView tvQs;
    private TextView tvAns;
    private TextView tvLevel;
    private TableLayout mLine1;
    private TableLayout mLine2;
    private TableLayout mLine3;
    private Button mResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //==============================================================
        mImgHang = findViewById(R.id.imgHang);
        mImgHangLose = findViewById(R.id.imgHangLose);

        mLine1 = findViewById(R.id.line1);
        mLine2 = findViewById(R.id.line2);
        mLine3 = findViewById(R.id.line3);

        tvQs = findViewById(R.id.tvQs);
        tvAns = findViewById(R.id.tvAns);
        tvLevel = findViewById(R.id.tvLevel);

        mResetButton = findViewById(R.id.btnReset);

        //32button
        int[] idButton = {R.id.btnA, R.id.btnB, R.id.btnC, R.id.btnD, R.id.btnE, R.id.btnF, R.id.btnG, R.id.btnH,
                R.id.btnI, R.id.btnJ, R.id.btnK, R.id.btnL, R.id.btnM, R.id.btnN, R.id.btnO, R.id.btnP, R.id.btnQ, R.id.btnR,
                R.id.btnS, R.id.btnT, R.id.btnU, R.id.btnV, R.id.btnW, R.id.btnX, R.id.btnY, R.id.btnZ};
        for (int id : idButton) {
            View v = findViewById(id);
            v.setOnClickListener(this);
        }
        //===============================================================
        listQA = new ArrayList<>();
        myRef = FirebaseDatabase.getInstance().getReference().child("Q&A");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String q = ds.child("question").getValue(String.class);
                    String a = ds.child("answer").getValue(String.class);

                    Log.d("TAG", q + " / " + a);
                    listQA.add(new QA(q, a));
                }
                question = listQA.get(0).getQuestion();
                answer = listQA.get(0).getAnswer();
                tvQs.setText(question);
                s = createHiddenAns(answer);
                tvAns.setText(s);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


//        setUp();
//        levelUp();


        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeFalse = 0;
                mImgHang.setImageLevel(timeFalse);

                s = createHiddenAns(answer);
                tvAns.setText(s);

                mImgHangLose.setVisibility(View.INVISIBLE);
                mResetButton.setVisibility(View.INVISIBLE);

                tvQs.setVisibility(View.VISIBLE);
                tvAns.setVisibility(View.VISIBLE);
                mLine1.setVisibility(View.VISIBLE);
                mLine2.setVisibility(View.VISIBLE);
                mLine3.setVisibility(View.VISIBLE);
            }
        });
    }

    public String createHiddenAns(String answer) {//Create "_ _ _ _ _"
        String s = "";
        for (int i = 0; i < answer.length(); i++) {
            s += "_";
        }
        return s;
    }

    public void onClick(View v) {
        input = ((Button) v).getText().toString();
        if (check()) {
            if (s.indexOf("_") != -1)
                updateAnsText();
            else{
                correctAnswer();
            }
        } else
            updateImg();
    }

    private void correctAnswer() {

    }

    public boolean check() {
        return answer.indexOf(input) != -1;
    }

    public void updateAnsText() {
        String[] ansArr = answer.split("");
        String[] sArr = s.split("");
        for (int i = 0; i < answer.length(); i++)
            if (ansArr[i].equals(input)) {
                sArr[i] = input;
            }
//        System.out.println(sArr[3]);
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
        tvAns.setText(answer);

        mImgHangLose.setVisibility(View.VISIBLE);
        mResetButton.setVisibility(View.VISIBLE);

        tvQs.setVisibility(View.INVISIBLE);
        mLine1.setVisibility(View.INVISIBLE);
        mLine2.setVisibility(View.INVISIBLE);
        mLine3.setVisibility(View.INVISIBLE);
    }


//        Log.d("TAG1", "listSize: " + tempList.size());

//        myRef.addValueEventListener(eventListener);

//    public ArrayList<QA> changeList() {
//        final ArrayList<QA> tempList = new ArrayList<>();
//        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    for (DataSnapshot dss : dataSnapshot.getChildren()) {
//
//                        String key = dss.getKey();
//                        String value = dss.getValue(String.class);
//                        QA a = new QA(key, value);
//                        tempList.add(a);
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                // ...
//            }
//        });
//        return tempList;
//    }

    //    public void levelUp() {
//        level++;
//        String lv = "Lv." + Integer.toString(level);
//        tvLevel.setText(lv);
//
//        question = listQA.get(level).getQuestion();
//        answer = listQA.get(level).getAnswer();
//
//        tvQs.setText(question);
//        tvAns.setText(createHiddenAns());
//    }


//    public void getNSetQAFromList() {
//        question = listQA.get(level).getQuestion();
//        answer = listQA.get(level).getAnswer();
//    }


}
