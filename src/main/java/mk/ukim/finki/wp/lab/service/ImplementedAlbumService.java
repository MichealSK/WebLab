package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;

import java.util.List;

public class ImplementedAlbumService implements AlbumService {
    AlbumRepository albumRepository;
    @Override
    public List<Album> findall() {
        return albumRepository.findAll();
    }
}
