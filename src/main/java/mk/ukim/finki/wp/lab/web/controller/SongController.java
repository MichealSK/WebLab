package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;

@Controller
@RequestMapping("/songs")
public class SongController {

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("songs", DataHolder.songs);
        model.addAttribute("albums", DataHolder.albums);
        model.addAttribute("error", error);
        return "listSongs";
    }

    @GetMapping("/add")
    public String addSong(Model model) {
        model.addAttribute("song", new Song (0L, "", "", "", 2000, DataHolder.albums.get(0)));
        model.addAttribute("albums", DataHolder.albums);
        model.addAttribute("url", "add/");
        return "add-song";
    }
    @GetMapping("/add-form")
    public String addSongCopy(Model model) {
        model.addAttribute("song", new Song (0L, "", "", "", 2000, DataHolder.albums.get(0)));
        model.addAttribute("albums", DataHolder.albums);
        model.addAttribute("url", "add/");
        return "add-song";
    }

    @PostMapping("/add/{songId}")
    public String saveSong(@PathVariable Long songId,
                           @RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId) {
        try {
            DataHolder.songs.add(new Song(Long.valueOf(DataHolder.songs.size()+1), trackId, title, genre, releaseYear, DataHolder.getAlbumById(albumId)));
            return "redirect:/songs";
        } catch (Exception e) {
            return "redirect:/songs?error=" + e.getMessage();
        }
    }

    @GetMapping("/edit/{songId}")
    public String editSong(@PathVariable Long songId, Model model) {
        Song song = DataHolder.getSongById(songId);
        model.addAttribute("song", song);
        model.addAttribute("albums", DataHolder.albums);
        model.addAttribute("url", "/songs/edit/");
        return "add-song";
    }
    @GetMapping("/edit-form/{songId}")
    public String editSongCopy(@PathVariable Long songId, Model model) {
        Song song = DataHolder.getSongById(songId);
        model.addAttribute("song", song);
        model.addAttribute("albums", DataHolder.albums);
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
            DataHolder.getSongById(songId).update(trackId, title, genre, releaseYear, DataHolder.getAlbumById(albumId));
            return "redirect:/songs";
        } catch (Exception e) {
            return "redirect:/songs?error=" + e.getMessage();
        }
    }

    @PostMapping("/delete/{songId}")
    public String deleteSong(@PathVariable Long songId) {
        DataHolder.deleteSongById(songId);
        return "redirect:/songs";
    }
}