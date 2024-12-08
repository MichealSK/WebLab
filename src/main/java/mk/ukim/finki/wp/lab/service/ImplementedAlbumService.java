package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplementedAlbumService implements AlbumService {
    public AlbumRepository albumRepository;
    public ImplementedAlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findall() {
        return albumRepository.findAll();
    }

    @Override
    public void add(Album album) {
        albumRepository.save(album);
    }

    @Override
    public Album getAlbumById(Long id) {
        return albumRepository.getReferenceById(id);
    }

    @Override
    public Album getAlbumByTitle(String title) {
        for(long i=0; i<albumRepository.count(); i++){
            if(albumRepository.getReferenceById(i).getName() == title) return albumRepository.getReferenceById(i);
        }
        return null;
    }
}
