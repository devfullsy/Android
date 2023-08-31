package com.kingkmotivation.filmquiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kingkmotivation.filmquiz.model.Question;

public class CheatActivity extends AppCompatActivity {

    private TextView tvReponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        tvReponse = findViewById(R.id.tvReponse);

        Intent intent = getIntent();

        Question question = (Question) intent.getSerializableExtra(MainActivity.KEY_QUESTION);

        tvReponse.setText(String.format("%s -> %s", question.getTexte(), question.getAnswer()));

    }

    @Override
    public boolean onSupportNavigateUp() {

        finish();
        return true;
    }
}