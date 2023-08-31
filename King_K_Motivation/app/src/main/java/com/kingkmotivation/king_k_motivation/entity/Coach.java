package com.kingkmotivation.king_k_motivation.entity;

public class Coach {
    private int id;
    private String firstName;
    private String secondName;
    private int number;
    private String picture;

    public Coach() {
    }

    public Coach(int id, String firstName, String secondName, int number, String picture) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.number = number;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Coach{" +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", number=" + number +
                '}';
    }
}
