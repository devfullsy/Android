package com.kingkmotivation.kingkmotivation.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Video implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "favori")
    private int favori;

    @ColumnInfo(name = "cathegorie")
    private String cathegorie;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "url")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Video() {
    }

    public Video(Long id, int favori, String cathegorie, String name, String description, String url) {
        this.id = id;
        this.favori = favori;
        this.cathegorie = cathegorie;
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public int getFavori() {
        return favori;
    }

    public void setFavori(int favori) {
        this.favori = favori;
    }

    public String getCathegorie() {
        return cathegorie;
    }

    public void setCathegorie(String cathegorie) {
        this.cathegorie = cathegorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", favori=" + favori +
                ", cathegorie='" + cathegorie + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
