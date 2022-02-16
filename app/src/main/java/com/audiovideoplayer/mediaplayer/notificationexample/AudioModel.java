package com.audiovideoplayer.mediaplayer.notificationexample;

import android.net.Uri;

public class AudioModel {
    private  String title;
    private  String artist;
    private  String url;
    private  String name;
    private  String size;
    private  int image;
    private Uri uri;

    public AudioModel(String title, String artist, String url, String name, String size, int image, Uri uri) {

        this.title = title;
        this.artist = artist;
        this.url = url;
        this.name = name;
        this.size = size;
        this.image=image;
        this.uri = uri;
    }

    public AudioModel(Uri contentUri, String name, int duration, int size) {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public int getImage(){
        return image;
    }
    public  void setImage(int image){
        this.image=image;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
