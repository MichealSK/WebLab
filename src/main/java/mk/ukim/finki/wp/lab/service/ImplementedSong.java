package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplementedSong implements SongService {
    private final SongRepository songRepository;
    public ImplementedSong(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        songRepository.getReferenceById(song.getId()).addArtist(artist);
        return artist;
    }

    @Override
    public Song findByTrackId(String trackId) {
        for(long i=0; i<songRepository.count(); i++){
            if(songRepository.getReferenceById(i).getTrackId() == trackId) return songRepository.getReferenceById(i);
        }
        return null;
    }

    @Override
    public void add(Song song) {
        songRepository.save(song);
    }

    @Override
    public int size() {
        return (int) songRepository.count();
    }

    @Override
    public Song getSongById(Long id) {
        return songRepository.getReferenceById(id);
    }

    @Override
    public void updateSong(Long id, String trackId, String title, String genre, int releaseYear, Album albumId) {
        songRepository.getReferenceById(id).update(trackId, title, genre, releaseYear, albumId);
        songRepository.save(songRepository.getReferenceById(id));
    }

    @Override
    public void deleteSongById(Long id) {
        songRepository.deleteById(id);
    }
}
