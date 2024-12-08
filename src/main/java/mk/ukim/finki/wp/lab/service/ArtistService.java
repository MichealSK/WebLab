package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> listArtists();
    Artist ArtistfindById(Long id);
    Optional<Artist> findById(Long id);
    void add(Artist artist);
    ArrayList<Artist> getArtistsBySearch(String substringName, String substringSur, String substringBio);
}
