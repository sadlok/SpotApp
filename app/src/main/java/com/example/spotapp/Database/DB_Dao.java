package com.example.spotapp.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.spotapp.Model.Song;

import java.util.List;

@Dao
public interface DB_Dao {
    @Query("SELECT * FROM Song")
    public List<Song>
    LoadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void
    insertSong(Song song);

    @Delete
    public void
    deleteSong(Song song);
}
