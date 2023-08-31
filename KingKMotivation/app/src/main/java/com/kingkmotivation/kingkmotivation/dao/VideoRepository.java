package com.kingkmotivation.kingkmotivation.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kingkmotivation.kingkmotivation.entities.Video;

import java.util.List;

@Dao
public interface VideoRepository {

    @Query("SELECT * FROM video WHERE id = :id")
    public Video find(Long id);

    @Query("SELECT * FROM video")
    public List<Video> list();

    @Insert
    public void add(Video... videos);

    @Update
    public void update(Video... videos);

    @Delete
    public void delete(Video... videos);
}
