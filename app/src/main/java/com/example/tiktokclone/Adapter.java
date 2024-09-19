package com.example.tiktokclone;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktokclone.databinding.ReelDesignBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.VideoHolder>{
    Context context;
    ArrayList<model> modelArrayList=new ArrayList<>();
    boolean isPlaying=false;
    public Adapter(Context context, ArrayList<model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.reel_design,parent,false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
        holder.binding.videoView.setVideoPath(modelArrayList.get(position).getVideoUrl());
        holder.binding.profileImage.setImageResource(modelArrayList.get(position).getProfile());
        holder.binding.name.setText(modelArrayList.get(position).getName());
        holder.binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                isPlaying=true;
            }
        });
        holder.binding.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                isPlaying=true;
            }
        });
        holder.binding.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying){
                    holder.binding.videoView.pause();
                    isPlaying=false;
                    holder.binding.pause.setVisibility(View.VISIBLE);

                }else{
                    holder.binding.videoView.resume();
                    isPlaying=true;
                    holder.binding.pause.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder {
        ReelDesignBinding binding;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            binding=ReelDesignBinding.bind(itemView);
        }
    }
}
