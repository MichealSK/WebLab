package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String trackId;
    String title;
    String genre;
    int releaseYear;
    @ManyToMany
    List<Artist> performers = new ArrayList<>();
    @ManyToOne
    Album album = null;

    public Song(){
        this.trackId = "";
        this.title = "";
        this.genre = "";
        this.releaseYear = 2000;
    }
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

    public Song(String trackId, String title, String genre, int releaseYear, Album album) {
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
