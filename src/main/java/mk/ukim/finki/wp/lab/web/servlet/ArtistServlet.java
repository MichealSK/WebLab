package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.ImplementedArtist;
import mk.ukim.finki.wp.lab.service.ImplementedSong;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name="Artists", urlPatterns = "/artist")
public class ArtistServlet extends HttpServlet {
    SpringTemplateEngine template;
    ArtistService service;

    private ImplementedArtist artists;

    public ArtistServlet(SpringTemplateEngine template, ArtistService service, ImplementedArtist artists) {
        this.template = template;
        this.service = service;
        this.artists = artists;
    }
    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        artists = context.getBean(ImplementedArtist.class);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String songId = req.getParameter("song");

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        context.setVariable("artists", artists.listArtists());
        context.setVariable("songId", songId);
        this.template.process("artistsList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String songId = req.getParameter("song");
        String nameSub = req.getParameter("subname");
        String surSub = req.getParameter("subsurname");
        String bioSub = req.getParameter("subbio");

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        context.setVariable("artists", artists.getArtistsBySearch(nameSub, surSub, bioSub));
        context.setVariable("songId", songId);
        this.template.process("artistsList.html", context, resp.getWriter());

    }
}
