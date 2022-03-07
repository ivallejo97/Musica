package Entities;

import java.io.Serializable;
import java.util.Date;

public class Album implements Serializable {
    int id_artist;
    String firstname;
    String lastname;
    Date born;
    Date died;

    public Album(int id_artist, String firstname, String lastname, Date born, Date died){
        super();
        this.id_artist = id_artist;
        this.firstname = firstname;
        this.lastname = lastname;
        this.born = born;
        this.died = died;
    }
}
