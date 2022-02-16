package com.audiovideoplayer.mediaplayer.notificationexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.ViewHolder> {
    ArrayList<AudioModel> audioModelArrayList;
    Context context;
    public AudioAdapter( ArrayList<AudioModel> audioModelArrayList, Context context){
        this.audioModelArrayList= audioModelArrayList;
        this.context= context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
      View view=layoutInflater.inflate(R.layout.audio_list,parent,false);
      return  new AudioAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.artist_list_txt.setText(audioModelArrayList.get(position).getArtist());
      holder.title_list_txt.setText(audioModelArrayList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return audioModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView audio_list_image;
        TextView artist_list_txt,title_list_txt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            audio_list_image=itemView.findViewById(R.id.audio_list_image);
            artist_list_txt=itemView.findViewById(R.id.artist_list_txt);
            title_list_txt=itemView.findViewById(R.id.title_list_txt);

        }
    }
}
