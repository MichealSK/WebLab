package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;

import java.util.ArrayList;
import java.util.List;

public interface AlbumService {
    List<Album> albums = new ArrayList<>();
    List<Album> findall();
}
