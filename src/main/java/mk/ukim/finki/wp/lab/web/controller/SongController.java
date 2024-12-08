package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import mk.ukim.finki.wp.lab.service.ImplementedSong;
import mk.ukim.finki.wp.lab.service.ImplementedAlbumService;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final ImplementedSong songs;
    private final ImplementedAlbumService albums;
    public SongController(ImplementedSong songs, ImplementedAlbumService albums){
        this.songs = songs;
        this.albums = albums;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("songs", songs.listSongs());
        model.addAttribute("albums", albums.findall());
        model.addAttribute("error", error);
        return "listSongs";
    }

    @GetMapping("/add")
    public String addSong(Model model) {
        model.addAttribute("song", new Song ("", "", "", 2000, new Album()));
        model.addAttribute("albums", albums.findall());
        model.addAttribute("url", "add/");
        return "add-song";
    }
    @GetMapping("/add-form")
    public String addSongCopy(Model model) {
        model.addAttribute("song", new Song ("", "", "", 2000, new Album()));
        model.addAttribute("albums", albums.findall());
        model.addAttribute("url", "add/");
        return "add-song";
    }

    @PostMapping("/add/{songId}")
    public String saveSong(
                           @RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId) {
        try {
            songs.add(new Song(trackId, title, genre, releaseYear, albums.getAlbumById(albumId)));
            return "redirect:/songs";
        } catch (Exception e) {
            return "redirect:/songs?error=" + e.getMessage();
        }
    }

    @GetMapping("/edit/{songId}")
    public String editSong(@PathVariable Long songId, Model model) {
        Song song = songs.getSongById(songId);
        model.addAttribute("song", song);
        model.addAttribute("albums", albums.findall());
        model.addAttribute("url", "/songs/edit/");
        return "add-song";
    }
    @GetMapping("/edit-form/{songId}")
    public String editSongCopy(@PathVariable Long songId, Model model) {
        Song song = songs.getSongById(songId);
        model.addAttribute("song", song);
        model.addAttribute("albums", albums.findall());
        model.addAttribute("url", "edit/"+songId);
        return "add-song";
    }

    @PostMapping("/edit/{songId}")
    public String updateSong(@PathVariable Long songId,
                             @RequestParam String title,
                             @RequestParam String trackId,
                             @RequestParam String genre,
                             @RequestParam int releaseYear,
                             @RequestParam Long albumId) {
        try {
            songs.updateSong(songId, trackId, title, genre, releaseYear, albums.getAlbumById(albumId));
            return "redirect:/songs";
        } catch (Exception e) {
            return "redirect:/songs?error=" + e.getMessage();
        }
    }

    @PostMapping("/delete/{songId}")
    public String deleteSong(@PathVariable Long songId) {
        songs.deleteSongById(songId);
        return "redirect:/songs";
    }
}