package com.kingkmotivation.kingkmotivation.base;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kingkmotivation.kingkmotivation.dao.VideoRepository;
import com.kingkmotivation.kingkmotivation.entities.Video;

@Database(entities = {Video.class}, version = 1)
public abstract class DataVideo extends RoomDatabase {

    public static final String DATABASE_NAME = "video";

    public static DataVideo getDb(Context context){
        return Room.databaseBuilder(context, DataVideo.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public abstract VideoRepository videoRepository();
}
