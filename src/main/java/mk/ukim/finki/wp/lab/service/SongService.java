package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import java.util.List;

public interface SongService{
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(String trackId);
    void add(Song song);
    int size();
    Song getSongById(Long id);
    void updateSong(Long id, String trackId, String title, String genre, int releaseYear, Album albumId);
    void deleteSongById(Long id);
}
