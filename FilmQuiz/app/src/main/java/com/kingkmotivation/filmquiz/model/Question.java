package com.kingkmotivation.filmquiz.model;

import android.widget.TextView;

import java.io.Serializable;

public class Question implements Serializable {
    private  int id;
    private String texte;
    private Boolean answer;

    public Question() {
    }

    public Question(String texte,Boolean answer) {
        this.texte = texte;
        this.answer= answer;
    }

    public String getTexte() {
        return texte;
    }

    public Boolean getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return texte;
    }

}
