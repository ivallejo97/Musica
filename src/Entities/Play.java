package Entities;

public class Play {

    String instrument;
    Artist artist;
    Song song;

    public Play(String instrument, Artist artist, Song song){
        super();
        this.instrument = instrument;
        this.artist = artist;
        this.song = song;
    }
    public Play() {
        super();
    }

    public String getInstrument() {
        return instrument;
    }
    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Artist getArtist() {
        return artist;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Song getSong() {
        return song;
    }
    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "Play{" +
                "instrument='" + instrument + '\'' +
                ", artist=" + artist.firstname +
                ", song=" + song.tittle_song +
                '}';
    }

}
