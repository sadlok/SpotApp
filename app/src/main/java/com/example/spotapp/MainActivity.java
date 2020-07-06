package com.example.spotapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import  android.widget.*;
import com.example.spotapp.Connectors.SongService;
import com.example.spotapp.Model.Song;
import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;
import  com.example.spotapp.Database.DB;
import  com.example.spotapp.Database.DB_App;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;


public class MainActivity extends AppCompatActivity {

    private TextView userView;
    private TextView songView;
    private Button saved;
    private Song song;
    private static final String SCOPES = "user-read-recently-played,user-library-modify,user-read-email,user-read-private";
    private SongService songService;
    private DB db;
    public ArrayList<Song> recentlyPlayedTracks;
    List<Song> songs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.main);
        songService = new SongService(getApplicationContext());
//        userView = (TextView) findViewById(R.id.user);
//        songView = (TextView) findViewById(R.id.song);
//        addBtn = (Button) findViewById(R.id.add);
        saved = (Button) findViewById(R.id.saved);
        db = DB.getDatabase(getApplicationContext());
        SharedPreferences sharedPreferences = this.getSharedPreferences("SPOTIFY", 0);
        //userView.setText(sharedPreferences.getString("userid", "No User"));

        getTracks();
        saved.setOnClickListener(addListener);


    }



    private View.OnClickListener addListener = v -> {


//        Intent newintent = new Intent(MainActivity.this, SplashActivity.class);
//        startActivity(newintent);
    };


    private void getTracks() {
        songService.getRecentlyPlayedTracks(() -> {
            recentlyPlayedTracks = songService.getSongs();
            updateSong();
        });
    }

    private void updateSong() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        // создаем адаптер
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        MainAdapter adapter = new MainAdapter(this, recentlyPlayedTracks);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
        }

        public void saveToDB(int pos)
        {
            db.getSongDao().insertSong(recentlyPlayedTracks.get(pos));
            Toast toast = Toast.makeText(this,"Добавленно в базу",LENGTH_SHORT);
        }
    }

