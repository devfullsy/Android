package com.kingkmotivation.todo.doa;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kingkmotivation.todo.entities.Todo;

import java.util.List;

@Dao
public interface TodoRepository {

    @Query("SELECT * FROM todo WHERE id = :id")
    public Todo find(Long id);

    @Query("SELECT * FROM todo")
    public List<Todo> list();

    @Insert
    public void add(Todo... todos);

    @Update
    public void update(Todo... todos);

    @Delete
    public void delete(Todo... todos);
}