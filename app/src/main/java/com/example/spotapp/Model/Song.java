package com.example.spotapp.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.spotapp.Database.Converter;

@Entity
public class Song {

    @PrimaryKey @NonNull
    private String id;
    private String name;
    private String artist;
    private String imageURL;
    private Boolean liked;
    private Long timestamp;
    @TypeConverters({Converter.class})
    private Playlist playlist;

    public Song(String id, String name, String artist, String imageURL,Boolean liked,Long timestamp,Playlist playlist) {
        this.name = name;
        this.id = id;
        this.artist = artist;
        this.imageURL = imageURL;
        this.liked = liked;
        this.timestamp = timestamp;
        this.playlist = playlist;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if(object == null || object.getClass()!= this.getClass())
            return false;

        // type casting of the argument.
        Song song= (Song) object;

        // comparing the state of argument with
        // the state of 'this' Object.
        return (song.id.equals(this.id));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
