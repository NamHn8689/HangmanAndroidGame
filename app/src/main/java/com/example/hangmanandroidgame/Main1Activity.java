package com.example.hangmanandroidgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main1Activity extends Activity {
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        btnStart = findViewById(R.id.btnReStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent startIntent = new Intent(Main1Activity.this, Main2Activity.class);
                                            startActivity(startIntent);
                                        }
                                    }
        );
    }
}
