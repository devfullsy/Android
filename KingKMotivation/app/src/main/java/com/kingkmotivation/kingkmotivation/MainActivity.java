package com.kingkmotivation.kingkmotivation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.kingkmotivation.kingkmotivation.base.DataVideo;
import com.kingkmotivation.kingkmotivation.entities.Video;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //la liste qui permettra de stocker les données de la base à la ligne 62
    private List<Video> videos;
    private Context context;
    private RecyclerView recyVideo;

    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        recyVideo = findViewById(R.id.rvVideo);
        context = getApplicationContext();
        //on cree un layoutManager pour surveiller la vue
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(context);
        //on met la taille pour pouvoir scroller si la vue est au max
        recyVideo.setHasFixedSize(true);
        recyVideo.setLayoutManager(layoutManager);
    }

    //les tois petits point pour basculer sur une autre activité
    //la class ajouvideo ce touve dans le dossier menu
    //on cree un menu en faisant click droit sur res -> new ->  android resources files
    // -> resource type on choisi menu
     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ajoutvideo,menu);
        return true;

    }

    //on recupere l'id de l'element choisi sur le menu ici on n'a qu'un
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //mnajoutvideo c'est id de l'activité menu si on click on recupere l'id et on charge la nouvelle activite
        if (item.getItemId()==R.id.mnajoutvideo){
            Intent activite = new Intent(context, AddVideo.class);
            startActivity(activite);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //dans la methode onStart on charge la liste depuis la base de données
    //on passe la liste à l'adapteur (on explique le fonctionnement dans la class VideoAdapteur)
   @Override
    protected void onStart() {
        super.onStart();
        videos = DataVideo.getDb(context).videoRepository().list();
       //on affiche la liste des video dans le recyclerview
       //on affiche chaque element de la liste dans un item de l'avtivité video_item
       //on donne met un OnItemClickListener pour ecouter le click la methode provient de l'adapter
        VideoAdapter videoAdapter = new VideoAdapter(videos, new VideoAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(Video video) {
                //une fois qu'on click on change d'activité et on envoi un objet video
                // avec la methode putExtrat
                Intent activite = new Intent(context, InfosVideo.class);
                activite.putExtra("video",video);
                startActivity(activite);
            }
        } );
        //ici on met l'adaptater dans le recycler
        recyVideo.setAdapter(videoAdapter);
    }
}