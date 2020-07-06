package com.example.spotapp.Database;

import androidx.room.TypeConverter;

import com.example.spotapp.Model.Playlist;
import com.google.gson.Gson;
import androidx.room.TypeConverter;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;


public class Converter {

    @TypeConverter
    public String fromPlaylist(Playlist playlist)
    {
        Gson gson = new Gson();
        String json = gson.toJson(playlist);
        return json;
    }

    @TypeConverter
    public Playlist toPlaylist(String string)
    {
        Type Playlist = new TypeToken<Playlist>(){}.getType();
        return new Gson().fromJson(string, Playlist);
    }
}
