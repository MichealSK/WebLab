package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();
    public static List<Album> albums = new ArrayList<>();

    @PostConstruct
    public void init() {
        // albums
        albums.add(new Album(1L, "Sheer Heart Attack", "Rock", "1974"));
        albums.add(new Album(2L, "Bad", "Pop", "1987"));
        albums.add(new Album(3L, "News to the World", "Rock", "1977"));
        albums.add(new Album(4L, "Thriller", "Pop", "1983"));
        albums.add(new Album(5L, "The Marshall Mathers LP 2", "Hip-Hop", "2013"));

        artists.add(new Artist(1L, "Michael", "Jackson", "American singer, songwriter, dancer, and philanthropist. Dubbed the \"King of Pop\""));
        artists.add(new Artist(2L, "Freddie", "Mercury", "British singer and songwriter who achieved worldwide fame as the lead vocalist and pianist of the rock band Queen."));
        artists.add(new Artist(3L, "Kanye", "West", "\"I am Kanye West, and I'm the Kanye Best\" - Kanye West"));
        artists.add(new Artist(4L, "Marshall", "Mathers", "Eminem is a renowned American rapper, songwriter, record producer, and actor. He is widely regarded as one of the greatest rappers of all time."));
        artists.add(new Artist(5L, "Toshe", "Proeski", "Todor Proeski was dubbed the \"Elvis Presley of the Balkans\" by BBC News."));

        songs.add(new Song(1L, "Smooth_Criminal", "Smooth Criminal", "Pop", 1988, getAlbumById(2L)));
        songs.add(new Song(2L, "Billie_Jean", "Billie Jean", "Pop", 1983, getAlbumById(4L)));
        songs.add(new Song(3L, "Champions", "We are the Champions", "Rock", 1977, getAlbumById(3L)));
        songs.add(new Song(4L, "Killer_Queen", "Killer Queen", "Rock", 1974, getAlbumById(1L)));
        songs.add(new Song(5L, "Rap_god", "Rap god", "Hip Hop", 2013, getAlbumById(5L)));
    }

    public static Song getSongById(Long id) {
        int i = 0;
        while(true) {
            if (songs.get(i).getId() == id) return songs.get(i);
            i++;
        }
    }

    public static void deleteSongById(Long id) {
        int i = 0;
        while(true) {
            if (songs.get(i).getId() == id) {
                songs.remove(i);
                break;
            }
            i++;
        }
    }

    public static Artist getArtistById(Long id) {
        int i = 0;
        while(true) {
            if (artists.get(i).getId() == id) return artists.get(i);
            i++;
        }
    }

    public static Album getAlbumById(Long id) {
        int i = 0;
        while(true) {
            if (albums.get(i).getId() == id) return albums.get(i);
            i++;
        }
    }
}
