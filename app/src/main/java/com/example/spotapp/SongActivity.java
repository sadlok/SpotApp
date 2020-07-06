package com.example.spotapp;

import androidx.appcompat.app.AppCompatActivity;
import  com.example.spotapp.MainActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SongActivity extends AppCompatActivity {
    ImageView img;
    TextView tArt;
    TextView tName;
    Button saveImg;
    Button dbSave;
    int Pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        img = (ImageView) findViewById(R.id.imgAlbum);
        tArt = (TextView) findViewById(R.id.textArtist);
        tName = (TextView) findViewById(R.id.textSongName);
        saveImg = (Button) findViewById((R.id.btnSaveImg));
        dbSave = (Button) findViewById(R.id.btnDB);

        Bundle b = getIntent().getExtras();
        String name = "";
        String art = "";
        String imgUrl ="";
        Pos = 0;
        if(b != null) {
            name = b.getString("name");
            art = b.getString("Artist");
            imgUrl = b.getString("img");
            Pos = b.getInt("pos");

        }
        tArt.setText(art);
        tName.setText(name);
        Picasso.get().load(imgUrl).into(img);
        dbSave.setOnClickListener(addListener);
    }

    private View.OnClickListener addListener = v -> {



    };
    }

