package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ImplementedSong implements SongService {
    SongRepository repository;

    public ImplementedSong(SongRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Song> listSongs() {
        return null;
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return null;
    }

    @Override
    public Song findByTrackId(String trackId) {
        return null;
    }
}
