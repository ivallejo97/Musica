package Entities;

import java.sql.Time;

public class Song {
    int id_song;
    String code_album;
    String tittle_song;
    Float duration_song;
    public Album album;

    public Song(int id_song, String code_album, String tittle_song, Float duration_song, Album album){
        super();
        this.id_song = id_song;
        this.code_album = code_album;
        this.tittle_song = tittle_song;
        this.duration_song = duration_song;
        this.album = album;
    }
    public Song(){
        super();
    }

    public int getId_song() {
        return id_song;
    }
    public void setId_song(int id_song) {
        this.id_song = id_song;
    }
    public String getCode_album() {
        return code_album;
    }
    public void setCode_album(String code_album) {
        this.code_album = code_album;
    }
    public String getTittle_song() {
        return tittle_song;
    }
    public void setTittle_song(String tittle_song) {
        this.tittle_song = tittle_song;
    }
    public Float getDuration_song() {
        return duration_song;
    }
    public void setDuration_song(Float duration_song) {
        this.duration_song = duration_song;
    }

    public Album getAlbum(){return album;}
    public void setAlbum(Album album){this.album = album;}


    @Override
    public String toString() {
        return "Song [id_song=" + id_song + ", code_album=" + code_album
                + ", tittle_song=" + tittle_song + ", duration_song="
                + duration_song + "]";
    }
}
