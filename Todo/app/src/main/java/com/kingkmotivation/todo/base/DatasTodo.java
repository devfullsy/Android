package com.kingkmotivation.todo.base;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kingkmotivation.todo.doa.TodoRepository;
import com.kingkmotivation.todo.entities.Todo;

@Database(entities = {Todo.class}, version = 1)
public abstract class DatasTodo extends RoomDatabase {

    public static final String DATABASE_NAME = "todo";

    public static DatasTodo getDb(Context context){
        return Room.databaseBuilder(context, DatasTodo.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }
    public abstract TodoRepository todoRepository();
}