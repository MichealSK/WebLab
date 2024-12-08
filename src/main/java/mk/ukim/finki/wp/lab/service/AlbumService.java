package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;

import java.util.ArrayList;
import java.util.List;

public interface AlbumService {
    List<Album> findall();
    void add(Album album);
    Album getAlbumById(Long id);
    Album getAlbumByTitle(String title);
}
