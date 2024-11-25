package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
    List<Song> songRepository;

    public List<Song> findAll() {
        return songRepository;
    }

    public Artist addArtistToSong(Artist artist, Song song){
        return null;
    }
}
