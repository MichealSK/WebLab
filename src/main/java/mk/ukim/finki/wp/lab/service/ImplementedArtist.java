package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplementedArtist implements ArtistService {
    ArtistRepository repository;

    public ImplementedArtist(ArtistRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Artist> listArtists() {
        return null;
    }

    @Override
    public Artist ArtistfindById(Long id) {
        return null;
    }
}
