package com.than;

import java.util.List;

public class Content {
    private int id;
    private String text;
    private int userId;

    private String time;

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", userId=" + userId +
                ", time='" + time + '\'' +
                ", photos=" + photos +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private List<Photo> photos;

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
