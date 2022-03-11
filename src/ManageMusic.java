import java.io.IOException;

public class ManageMusic {
    public static void main(String[] args) throws IOException {
        FileAccessor fa = new FileAccessor();

        fa.readArtistFile("artist.txt");
        fa.printArtist();

        fa.readAlbum("albums.txt");
        fa.printAlbums();

        fa.readSongFile("songs.txt");
        fa.printAlbums();

        fa.readPlayFile("plays.txt");
        fa.printPlays();
    }

}
