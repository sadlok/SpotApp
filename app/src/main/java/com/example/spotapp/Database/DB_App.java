package com.example.spotapp.Database;


import android.app.Application;

import androidx.room.Room;


public class DB_App
        extends Application {

    public static DB_App instance;
    private DB database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, DB.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public static DB_App getInstance() {
        return instance;
    }

    public DB getDatabase() {
        return DB.getDatabase(getApplicationContext());
    }

}