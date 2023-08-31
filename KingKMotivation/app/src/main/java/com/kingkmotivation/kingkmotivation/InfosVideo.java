package com.kingkmotivation.kingkmotivation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.icu.text.IDNA;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kingkmotivation.kingkmotivation.entities.Video;

public class InfosVideo extends AppCompatActivity {

    private  Video video;
    private TextView tvtitre,tvdescrp,tvcathegorie,tvurl;
    private String titre,url,description,cathegorie;

    private Button btnvoirvideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_video);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //on recupere l'objet qui à ete envoyé depuis la classe MainActivity
        //en cliquant sur la video_item de la vue
        //l'object est envoyé avec la methode putExtra
        // on le recupere en le deserialisant
        video = (Video) getIntent().getSerializableExtra("video");
        //on le decompose on recupere les parametre de l'objet dans des String
        titre = video.getName();
        url = video.getUrl();
        description = video.getDescription();
        cathegorie = video.getCathegorie();
        // on recupere les id des champs dans lesquels on veut afficher les valeurs
        btnvoirvideo = findViewById(R.id.btnVoirVideo);
        tvtitre = findViewById(R.id.tvTitre);
        tvdescrp = findViewById(R.id.tvDescriptionDT);
        tvcathegorie = findViewById(R.id.tvCathegorieDT);
        tvurl = findViewById(R.id.tvUrl);
        // on met les valeurs recuper dans les textview
        tvtitre.setText(titre);
        tvurl.setText(url);
        tvcathegorie.setText(cathegorie);
        tvdescrp.setText(description);

    btnvoirvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //en clickant sur le bouton on ouvre youtube
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                try {
                    //on demande au context de demarer l'activité
                    InfosVideo.this.startActivity(intent);

                } catch (ActivityNotFoundException e){

                }
            }
        });
    }

// ça c'est la flech goBack
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}