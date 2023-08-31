package com.kingkmotivation.filmquiz.controleur;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kingkmotivation.filmquiz.data.Questions;
import com.kingkmotivation.filmquiz.model.Question;

import java.util.ArrayList;
import java.util.List;

public class ContolQuestions {
   private Questions tableauQuestion = new Questions();
   private List<Question> listQuestion = new ArrayList<>();

   private Question obQuestion;

    public ContolQuestions() {

    }

    public List creationTab(){

        String[] tableau = tableauQuestion.getTabQuestion();

        for (int i = 0; i < tableau.length ; i++) {
            if (i == 0){
                obQuestion = new Question(tableau[i], false);
                listQuestion.add(obQuestion);

            }else {
                obQuestion = new Question(tableau[i], true);
                listQuestion.add(obQuestion);
            }

        }
        return listQuestion;
    }

   /* public String gameOver(int score){
        return "SCORE :"+score;
    }*/

}
