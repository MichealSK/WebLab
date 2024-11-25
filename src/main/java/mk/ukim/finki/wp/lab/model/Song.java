package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.Getter;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
public class Song {
    Long id;
    String trackId;
    String title;
    String genre;
    int releaseYear;
    List<Artist> performers;
    Album album = null;

    public Song(Long id, String trackId, String title, String genre, int releaseYear, List<Artist> performers) {
        this.id = id;
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
    }

    public Song(Long id, String trackId, String title, String genre, int releaseYear) {
        this.id = id;
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<Artist>();
    }

    public Song(Long id, String trackId, String title, String genre, int releaseYear, Album album) {
        this.id = id;
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<Artist>();
        this.album = album;
    }

    public void addArtist(Artist a) {
        performers.add(a);
    }

    public void update(String trackId, String title, String genre, int releaseYear, Album albumId) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = albumId;
    }
}
