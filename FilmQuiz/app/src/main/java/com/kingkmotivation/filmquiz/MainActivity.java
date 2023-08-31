package com.kingkmotivation.filmquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kingkmotivation.filmquiz.controleur.ContolQuestions;
import com.kingkmotivation.filmquiz.model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        public static final String KEY_INDEX ="index";
         public static final String KEY_QUESTION  ="indexQuestion";
        public static final String KEY_SCORE="score" ;
        private int i=0;
        private int score=0;
        private ContolQuestions tabQuestions = new ContolQuestions();
        private Button btnFalse, btnTrue, btnRestart;
        private TextView tvQuestion, tvScore;
        private List<Question> questions = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      questions = tabQuestions.creationTab();
      tvQuestion = findViewById(R.id.tvQuestion);
      tvScore = findViewById(R.id.tvScore);
      btnTrue = findViewById(R.id.btnTrue);
      btnFalse = findViewById(R.id.btnFalse);
      btnRestart = findViewById(R.id.btnRestart);
     btnRestart.setVisibility(View.GONE);
     if (savedInstanceState != null){
            i= savedInstanceState.getInt(KEY_INDEX);
            score = savedInstanceState.getInt(KEY_SCORE);
        }
     tvQuestion.setText(questions.get(i).toString());
     tvScore.setText(String.valueOf("SCORE :"+score));
      btnFalse.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if (!questions.get(i).getAnswer()){
                  score++;
                  tvScore.setText(String.valueOf("SCORE :"+score));
              }
              i= i+1;
              if (i< questions.size()){
                  tvQuestion.setText(questions.get(i).toString());
              }else  if (i==questions.size()){
                  btnVisibility(false);
              }
          }
      });

      btnTrue.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if (questions.get(i).getAnswer()){
                  score++;

                  tvScore.setText(String.valueOf("SCORE :"+score));
              }
              i= i+1;
              if (i< questions.size()){
                  tvQuestion.setText(questions.get(i).toString());
              }else if (i==questions.size()){
                  btnVisibility(false);
              }
          }
      });

      btnRestart.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              i = 0;
              score=0;
              btnVisibility(true);
              tvQuestion.setText(questions.get(i).toString());
          }
      });


    }
    private void btnVisibility(boolean show){
        tvQuestion.setText("FIN DE LA PARTIE");
        tvScore.setText(String.valueOf("SCORE :"+score));
        if(show){

            btnTrue.setVisibility(View.VISIBLE);
            btnFalse.setVisibility(View.VISIBLE);
            btnRestart.setVisibility(View.GONE);
        }
        else {
            btnTrue.setVisibility(View.GONE);
            btnFalse.setVisibility(View.GONE);
            btnRestart.setVisibility(View.VISIBLE);

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_INDEX,i);
        outState.putInt(KEY_SCORE,score);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_manu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== R.id.cheat) {
                    Intent activite = new Intent(getApplicationContext(),CheatActivity.class);
                    activite.putExtra(KEY_QUESTION, questions.get(i));
                        startActivity(activite);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}