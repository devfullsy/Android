package com.kingkmotivation.kingkmotivation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.kingkmotivation.kingkmotivation.base.DataVideo;
import com.kingkmotivation.kingkmotivation.entities.Video;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddVideo extends AppCompatActivity {
    Video video = new Video();
    private EditText etname, etdescrip, eturl;
    private Spinner cathe;
    private CheckBox cbfavori;
    private Button btnadd, btncancel;
    private String nomvideo, descripvideo, urlvideo, cathegorie;
    private int favori = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_video);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        etname = findViewById(R.id.etNomvideo);
        eturl = findViewById(R.id.etUrl);
        etdescrip = findViewById(R.id.etDescription);
        cathe = findViewById(R.id.spListe);
        btnadd = findViewById(R.id.btnAdd);
        btncancel = findViewById(R.id.btnCancel);
        cbfavori = findViewById(R.id.cbFavori);

        // pour le spinner (miste deroulante) vue que se sont des valeurs statics
        // on stock ses valeur dans un fichier dans les ressours dans le dossier values
        //on les recuper pour les stocker dans un tableau
        String[] listeCathego = getResources().getStringArray(R.array.choixfavori);
        //on transfirme cette liste en tableau
        List<String> cathefavori = new ArrayList<>(Arrays.asList(listeCathego));

        //on charge un tableau avec les choix à faire
        ArrayAdapter<String> spArrayAdapter
                = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                cathefavori
        );
        // on fait un choix dans la liste
        spArrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        cathe.setAdapter(spArrayAdapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomvideo = etname.getText().toString();
                urlvideo = eturl.getText().toString();
                descripvideo = etdescrip.getText().toString();
                cathegorie = cathe.getSelectedItem().toString();
                if (!nomvideo.isEmpty() && !urlvideo.isEmpty() && urlvideo.startsWith("https://www.youtube.com") && !descripvideo.isEmpty() ){
                    if (cbfavori.isChecked()){
                        favori=1;
                    }
                    video.setName(nomvideo);
                    video.setUrl(urlvideo);
                    video.setDescription(descripvideo);
                    video.setCathegorie(cathegorie);
                    video.setFavori(favori);
                    //avec avoir charger les champs on insert dans la base de données
                    DataVideo.getDb(getApplicationContext()).videoRepository().add(video);
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(), "les champs doivent etre saisis et l'url doit etre une video youtube ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}