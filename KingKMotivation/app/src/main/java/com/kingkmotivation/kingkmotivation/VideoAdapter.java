package com.kingkmotivation.kingkmotivation;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kingkmotivation.kingkmotivation.entities.Video;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    //on cree une interface qu'on appelera dans la class recyclerview
    //lorsqu'on click sur un item
    public interface OnItemClickListener {
        void onItemClick(Video video);
    }
    private List<Video> videos;

    private  OnItemClickListener listener;

    //le contructeur de la class pour cree un object
    // pour utiliser l'interface OnItemClickListener avec 2 parametre
    // si on a pas besion du click sur l'item pas besion de l'interface
    //et le contructeur n'aura en parametre que la liste
    public VideoAdapter(List<Video> videos, OnItemClickListener listener){
        this.videos = videos;
        this.listener = listener;
    }
    //dans la class videoViewHolder on charge les id des textview
    // de l'activite video_item
    static class VideoViewHolder extends RecyclerView.ViewHolder{
        private TextView tvname , tvdescrip;
        public VideoViewHolder(View itemView){
            super(itemView);
            tvname = itemView.findViewById(R.id.tvnamerv);
            tvdescrip = itemView.findViewById(R.id.tvdescriprv);
        }

        //on affiche les données en provenance de la base de donnée
        // dans les champs correspondant dans l'activite video_item
        public void bind(final Video video, final OnItemClickListener listener) {
            tvname.setText(video.getName());
            tvdescrip.setText(video.getDescription());
            //on donne la possibilité de clicker sur toute la ligne
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(video);
                }
            });
    }
      }

      //la c'est pour adapter le champ avec les données qu'elle reçoit
    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.bind(videos.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }
}
