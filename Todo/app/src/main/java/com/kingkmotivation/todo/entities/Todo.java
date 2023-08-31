package com.kingkmotivation.todo.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Todo implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "urgency")
    private String urgency;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public Todo(String name, String urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    public Todo() {
    }

    @Override
    public String toString() {
        return  "name :     " + name + "\n" +
                "urgency :  " + urgency +"\n ";
    }
}

