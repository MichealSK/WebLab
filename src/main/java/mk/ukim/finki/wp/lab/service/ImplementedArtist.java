package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImplementedArtist implements ArtistService {

    private final ArtistRepository artistRepository;
    public ImplementedArtist(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {return artistRepository.findAll(); }

    @Override
    public Artist ArtistfindById(Long id) {
        return artistRepository.getReferenceById(id);
    }

    @Override
    public Optional<Artist> findById(Long id) {
        return Optional.of(artistRepository.getReferenceById(id));
    }

    @Override
    public void add(Artist artist) {
        artistRepository.save(artist);
    }

    @Override
    public ArrayList<Artist> getArtistsBySearch(String substringName, String substringSur, String substringBio) {
        long j;
        ArrayList<Artist> returnArt = new ArrayList<>();
        for (j=0; j<artistRepository.count(); j++) {
            returnArt.add(artistRepository.getReferenceById(j));
        }
        int i;
        for (i=0; i<returnArt.size(); i++) {
            if (!returnArt.get(i).getFirstName().contains(substringName)){
                returnArt.remove(i); i--;
            }
            else if (!returnArt.get(i).getLastName().contains(substringSur)){
                returnArt.remove(i); i--;
            }
            else if (!returnArt.get(i).getBio().contains(substringBio)){
                returnArt.remove(i); i--;
            }
        }
        return returnArt;
    }
}
