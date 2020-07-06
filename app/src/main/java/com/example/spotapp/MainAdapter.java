package com.example.spotapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spotapp.Model.Song;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private final Context context;
    //private RecyclerView.LayoutManager GridLayoutManager;
    private LayoutInflater inflater;
    private ArrayList<Song> recentlyPlayedTracks;

    MainAdapter(Context context, ArrayList<Song> recentlyPlayedTracks) {
        this.context = context;
        this.recentlyPlayedTracks = recentlyPlayedTracks;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
        Song song = recentlyPlayedTracks.get(position);
        Picasso.get().load(song.getImageURL()).into(holder.imageView);
        holder.nameView.setText(song.getName());
        holder.companyView.setText(song.getArtist());
    }

    @Override
    public int getItemCount() {
        return recentlyPlayedTracks.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView, companyView;
        ViewHolder(View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.image);
            nameView = (TextView) view.findViewById(R.id.name);
            companyView = (TextView) view.findViewById(R.id.company);
            imageView.setOnClickListener(this::onClick);
        }
        public void onClick(View v) {
            Log.d("onClick","*click*");
            int adapterposition = getAdapterPosition();
            Log.d("onClick","position="+adapterposition);
            this.onItemClick(adapterposition);
        }

        public void onItemClick(int position)
        {
            Intent intent = new Intent(context,SongActivity.class);
            Bundle b = new Bundle();
            b.putString("Artist", recentlyPlayedTracks.get(position).getArtist());
            b.putString("name", recentlyPlayedTracks.get(position).getName());
            b.putString("img", recentlyPlayedTracks.get(position).getImageURL());
            b.putInt("pos",position);
            intent.putExtras(b); //Put your id to your next Intent
            context.startActivity(intent);
        }
    }


}

