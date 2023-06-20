package com.example.myapplication.model;

public class BannerMovies {
Integer id;
String movieName;
String imageURL;
String fileURL;

    public BannerMovies(Integer id, String movieName, String imageURL, String fileURL) {
        this.id = id;
        this.movieName = movieName;
        this.imageURL = imageURL;
        this.fileURL = fileURL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }
}


