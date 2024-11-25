package mk.ukim.finki.wp.lab.repository;

import org.springframework.stereotype.Repository;

import mk.ukim.finki.wp.lab.model.Artist;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    List<Artist> artistRepository;

    public List<Artist> findAll() {
        return artistRepository;
    }

    /*public Optional<Artist> findById(Long id) {
        for (int i = 0; i < artistRepository.size(); i++) {
            if (artistRepository.get(i).getId() == id) {
                return new Optional<>(artistRepository.get(i));
            }
        }
    }*/
}
