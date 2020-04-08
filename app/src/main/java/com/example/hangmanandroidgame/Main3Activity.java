package com.example.hangmanandroidgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends Activity {
    Button mReStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mReStartButton = findViewById(R.id.btnReStart);
        mReStartButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Intent startIntent = new Intent(Main3Activity.this, Main1Activity.class);
                                                  startActivity(startIntent);
                                                  Log.d("taggggg", "chuyen");
                                              }
                                          }
        );
    }
}
