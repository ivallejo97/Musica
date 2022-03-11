import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;

import Entities.*;

/**
 * @author Joan Anton Pérez
 * @version FileAccessorv01
 * @since 29/12/2015
 */

public class FileAccessor {

    ArrayList<Artist> llistaArtist = new ArrayList();
    ArrayList<Album> llistaAlbums = new ArrayList();
    ArrayList<Play> llistaPlays = new ArrayList<>();

    public FileAccessor() {
    }

    /**
     * @param filename
     *            Aquest String correspon amb l'arxiu on s'emmagatzemen les
     *            dades de les instancies d'Artist
     * @throws IOException
     * @see Artist
     *
     *      <dt><b>Preconditions:</b>
     *      <dd>
     *      filename<>nil </br> llistaAutors == nil
     *      <dt><b>Postconditions:</b>
     *      <dd>
     *      llistaAutors<>nil
     */

    public void readArtistFile(String filename) throws IOException {
        int id_artist;
        String firstname, lastname;
        Date born = null, died = null;
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            id_artist = Integer.parseInt(str.nextToken());
            firstname = str.nextToken();
            lastname = str.nextToken();
            try {
                born = dateFormat.parse(str.nextToken());
                String fecha_muerte = str.nextToken();
                if (!fecha_muerte.equals("NULL")){
                    died = dateFormat.parse(str.nextToken());
                }


            } catch (ParseException e){

            }
            // System.out.println(id + name + country + year + active);
            llistaArtist.add(new Artist(id_artist, firstname, lastname, born, died));

        }
        br.close();

    }

    public void printArtist() {
        for (int i = 0; i < llistaArtist.size(); i++) {
            System.out.println(llistaArtist.get(i).toString());
        }
    }

    public void printAlbums() {
        // TODO
        //
        for (int i = 0; i < llistaAlbums.size(); i++) {
            System.out.println(llistaAlbums.get(i).toString());
            for (int j = 0; j < llistaAlbums.get(i).getSongs().size(); j++) {
                System.out.println(llistaAlbums.get(i).getSong(j).toString());
            }
        }
    }

    public void printPlays() {
        for (int i = 0; i < llistaPlays.size(); i++) {
            System.out.println(llistaPlays.get(i).toString());
        }
    }

    /**
     *
     * @param filename
     *            Aquest String correspon amb l'arxiu on s'emmagatzemen les
     *            dades de les instancies de Revista
     * @throws IOException
     *
     *             <dt><b>Preconditions:</b>
     *             <dd>
     *             filename<>nil </br> llistaRevistes == nil
     *             <dt><b>Postconditions:</b>
     *             <dd>
     *             llistaRevistes<>nil
     */

    public void readAlbum(String filename) throws IOException {
        String code, tittle_album, label;
        Date recorded_album;
        boolean available;
        DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            code = str.nextToken();
            tittle_album = str.nextToken();
            try {
                recorded_album = dateformat.parse(str.nextToken());
                label = str.nextToken();
                available = Boolean.parseBoolean(str.nextToken());
                // TODO
                // Cal afegir un objecte Magazine a la llista
                llistaAlbums.add(new Album(code, tittle_album, recorded_album,label,available));

            } catch (ParseException e) {
                System.err.println(" errada format data al fitxer");
                e.printStackTrace();
            }

        }
        br.close();

    }

    /**
     * @param filename
     *            Aquest String correspon amb l'arxiu on s'emmagatzemen les
     *            dades de les isntancies de Revista
     * @return ArrayList d'objectes Revista, amb els seus articles i la
     *         informació de l'autor
     * @throws IOException
     *
     *             <dt><b>Preconditions:</b>
     *             <dd>
     *             filename<>nil </br> llistaRevistes<>nil </br>
     *             llistaRevistes.getRevista(i).getArticles()== nil</br>
     *             <dt><b>Postconditions:</b>
     *             <dd>
     *             llistaRevistes.getRevistes()<>nil</br>
     *             llistaRevistes.getRevista(i).getArticles()<>nil</br>
     *             llistaRevistes.getRevista(i).getArticle(j)<>nil</br>
     *             llistaRevistes
     *             .getRevista(i).getArticle(j).getAutor()<>nil</br>
     *
     */
    public ArrayList<Album> readSongFile(String filename)
            throws IOException {
        int id_song;
        String code_album, tittle_song;
        Float duration_song;
        DateFormat dateformat = new SimpleDateFormat("YYYY-MM-DD");

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            id_song = Integer.parseInt(str.nextToken());
            code_album = str.nextToken();
            tittle_song = str.nextToken();
            duration_song = Float.valueOf(str.nextToken());
            // System.out.println(idArticle + ", idrev" + idRevista + ", idaut" + idAutor + ", titol " + titol 	+ data_creacio);
            Song a = new Song(id_song, code_album, tittle_song,duration_song,
                    llistaAlbums.get(Integer.parseInt(code_album)-1)
                    );
            //llistaAutors.get(idAutor-1).addArticle(a);
            llistaAlbums.get(Integer.parseInt(code_album)-1).addSong(a);

            // llistaAutors.add(new Autor(id, name, country, year, active));

        }
        br.close();



        return llistaAlbums;
        // TODO
    }
    /**
     * @param filename
     *            Aquest String correspon amb l'arxiu on s'emmagatzemen les
     *            dades de les isntancies de Revista
     * @return ArrayList d'objectes Revista, amb els seus articles i la
     *         informació de l'autor
     * @throws IOException
     *
     *
     */

    public ArrayList<Play> readPlayFile(String filename) throws IOException{

        int id_artist;
        int id_song;
        String instrument;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";

        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            id_artist = Integer.parseInt(str.nextToken());
            id_song = Integer.parseInt(str.nextToken());
            instrument = str.nextToken();

            Play a = null;

            for(int i = 0; i < llistaAlbums.size(); i++) {
                for (int j = 0; j < llistaAlbums.get(i).getSongs().size(); j++) {
                    if (llistaAlbums.get(i).getSong(j).getId_song() == id_song) {
                        a = new Play(instrument, llistaArtist.get(id_artist - 1), llistaAlbums.get(i).getSong(j));
                    }
                }
            }

            //llistaAutors.get(idAutor-1).addArticle(a);
            llistaPlays.add(a);

            // llistaAutors.add(new Autor(id, name, country, year, active));

        }

        return llistaPlays;
    }

}
