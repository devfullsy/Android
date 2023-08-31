package com.kingkmotivation.kingkmotivation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Welcome extends AppCompatActivity {
    private Handler waiter = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        waiter.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent sdActivite = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(sdActivite);
                finish();
            }
        }, 2000);
    }
}
