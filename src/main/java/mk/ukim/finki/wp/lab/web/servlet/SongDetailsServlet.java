package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name="SongDetails", urlPatterns = "/songDetails")
public class SongDetailsServlet extends HttpServlet {
    SpringTemplateEngine template;
    SongService songService;
    ArtistService artistService;

    public SongDetailsServlet(SpringTemplateEngine template, SongService songService, ArtistService artistService) {
        this.template = template;
        this.songService = songService;
        this.artistService = artistService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String songId = req.getParameter("song");
        String artistId = req.getParameter("artist");

        if(songId != null && artistId != null) {
            int songID = 0;
            while (!songId.equals(DataHolder.songs.get(songID).getTrackId())) {
                songID++;
            }
            DataHolder.songs.get(songID).addArtist(DataHolder.getArtistById(Long.parseLong(artistId)));
        }

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        for (int i = 0; i < DataHolder.songs.size(); i++) {
            WebContext context = new WebContext(webExchange);
            context.setVariable("song", DataHolder.songs.get(i));
            this.template.process("songDetails.html", context, resp.getWriter());
        }
    }
}