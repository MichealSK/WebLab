package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.ImplementedAlbumService;
import mk.ukim.finki.wp.lab.service.ImplementedArtist;
import mk.ukim.finki.wp.lab.service.ImplementedSong;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    private final ArtistRepository artists;
    private final SongRepository songs;
    private final AlbumRepository albums;

    public DataHolder(ArtistRepository artists, SongRepository songs, AlbumRepository albums) {
        this.artists = artists;
        this.songs = songs;
        this.albums = albums;
    }

    @PostConstruct
    public void init() {
        //songs.deleteAll();
        //artists.deleteAll();
        //albums.deleteAll();
        if (albums.count() == 0) {
            albums.save(new Album("Sheer Heart Attack", "Rock", "1974"));
            albums.save(new Album("Bad", "Pop", "1987"));
            albums.save(new Album("News to the World", "Rock", "1977"));
            albums.save(new Album("Thriller", "Pop", "1983"));
            albums.save(new Album("The Marshall Mathers LP 2", "Hip-Hop", "2013"));
        }
        if (artists.count() == 0) {
            artists.save(new Artist("Michael", "Jackson", "American singer, songwriter, dancer, and philanthropist. Dubbed the \"King of Pop\""));
            artists.save(new Artist("Freddie", "Mercury", "British singer and songwriter who achieved worldwide fame as the lead vocalist and pianist of the rock band Queen."));
            artists.save(new Artist("Kanye", "West", "\"I am Kanye West, and I'm the Kanye Best\" - Kanye West"));
            artists.save(new Artist("Marshall", "Mathers", "Eminem is a renowned American rapper, songwriter, record producer, and actor. He is widely regarded as one of the greatest rappers of all time."));
            artists.save(new Artist("Toshe", "Proeski", "Todor Proeski was dubbed the \"Elvis Presley of the Balkans\" by BBC News."));
        }
        if (songs.count() == 0 && albums.count() > 0) {
            List<Album> alb = new ArrayList<>();
            alb = albums.findAll();
            songs.save(new Song("Smooth_Criminal", "Smooth Criminal", "Pop", 1988, alb.get(1)));
            songs.save(new Song("Billie_Jean", "Billie Jean", "Pop", 1983, alb.get(3)));
            songs.save(new Song("Champions", "We are the Champions", "Rock", 1977, alb.get(2)));
            songs.save(new Song("Killer_Queen", "Killer Queen", "Rock", 1974, alb.get(1)));
            songs.save(new Song("Rap_god", "Rap god", "Hip Hop", 2013, alb.get(4)));
        }
    }

}
