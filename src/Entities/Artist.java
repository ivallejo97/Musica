package Entities;

import java.io.Serializable;
import java.util.Date;

public class Artist implements Serializable {

    int id_artist;
    String firstname;
    String lastname;
    Date born;
    Date died;

    public Artist(int id_artist, String firstname, String lastname, Date born, Date died){
        super();
        this.id_artist = id_artist;
        this.firstname = firstname;
        this.lastname = lastname;
        this.born = born;
        this.died = died;
    }
    public Artist(){

    }

    public int getId_artist() {
        return id_artist;
    }
    public void setId_artist(int id_artist){
        this.id_artist = id_artist;
    }
    public String getFirstname(){
        return firstname;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public Date getBorn(){
        return born;
    }
    public void setBorn(Date born){
        this.born = born;
    }
    public Date getDied(){
        return died;
    }
    public void setDied(Date died){
        this.died = died;
    }

    @Override
    public String toString() {
        return "Artist [id_artist=" + id_artist + ", firstname=" + firstname + ", lastname=" + lastname
                + ", born= " + born.toString() + ", died= " + (died == null ? "N/A" : died.toString())
                + "]";
    }
}
