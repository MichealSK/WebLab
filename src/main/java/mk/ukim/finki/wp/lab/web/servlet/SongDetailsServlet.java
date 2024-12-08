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
import mk.ukim.finki.wp.lab.service.ImplementedArtist;
import mk.ukim.finki.wp.lab.service.ImplementedSong;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name="SongDetails", urlPatterns = "/songDetails")
public class SongDetailsServlet extends HttpServlet {
    SpringTemplateEngine template;
    private ImplementedSong songs;
    private ImplementedArtist artists;

    public SongDetailsServlet(SpringTemplateEngine template, ImplementedSong songService, ImplementedArtist artistService) {
        this.template = template;
        this.songs = songService;
        this.artists = artistService;
    }
    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        songs = context.getBean(ImplementedSong.class);
        artists = context.getBean(ImplementedArtist.class);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String songId = req.getParameter("song");
        String artistId = req.getParameter("artist");

        if(songId != null && artistId != null) {
            int songID = 0;
            while (!songId.equals(songs.listSongs().get(songID).getTrackId())) {
                songID++;
            }
            songs.listSongs().get(songID).addArtist(artists.ArtistfindById(Long.parseLong(artistId)));
        }

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        for (int i = 0; i < songs.size(); i++) {
            WebContext context = new WebContext(webExchange);
            context.setVariable("song", songs.listSongs().get(i));
            this.template.process("songDetails.html", context, resp.getWriter());
        }
    }
}