package com.kingkmotivation.filmquiz.data;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    String[] tabQuestion = new String[4];
    public Questions() {
        tabQuestion[0] = "la capital de la FRANCE  est Lyon";
        tabQuestion[1] = "la capital de la RUSSIE est Moscou";
        tabQuestion[2] = "la capital de la Gambie est Banjul";
        tabQuestion[3] = "la capital du SENEGAL est Dakar";
    }


    public String[] getTabQuestion() {
        return tabQuestion;
    }
}
