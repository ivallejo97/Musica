package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Album implements Serializable {
    String code;
    String tittle_album;
    Date recorded_album;
    String label;
    boolean available;

    private Set<Song> songs = new HashSet<>();

    public Album(String code, String tittle_album, Date recorded_album, String label, boolean available){
        super();
        this.code = code;
        this.tittle_album = tittle_album;
        this.recorded_album = recorded_album;
        this.label = label;
        this.available = available;
    }
    public Album(){
        super();
    }



    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getTittle_album() {
        return tittle_album;
    }
    public void setTittle_album(String tittle_album) {
        this.tittle_album = tittle_album;
    }
    public Date getRecorded_album() {
        return recorded_album;
    }
    public void setRecorded_album(Date recorded_album) {
        this.recorded_album = recorded_album;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void addSong(Song song){
        songs.add(song);
    }
    public Song getSong(int i){
        Iterator<Song> it = songs.iterator();
        for (int j = 0; j < i; j++) {
            it.next();
        }
            return it.next();
    }
    public Set<Song> getSongs(){
        return songs;
    }
    public void setSongs(Set<Song> songs){
        this.songs = songs;}

    @Override
    public String toString() {
        return "Album [code=" + code +",tittle=" + tittle_album + ", recorded="
                + recorded_album.toString() + ", label=" + label + ", available=" + available
                + "]";
    }
}
