package mk.finki.ukim.mk.lab1.web.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab1.model.Movie;
import mk.finki.ukim.mk.lab1.model.TicketOrder;
import mk.finki.ukim.mk.lab1.service.MovieService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "movie-servlet", urlPatterns = "/servlet/movie")
public class MovieServlet extends HttpServlet {
    private final MovieService moviesService;
    private final SpringTemplateEngine springTemplateEngine;

    public MovieServlet(MovieService moviesService, SpringTemplateEngine springTemplateEngine) {
        this.moviesService = moviesService;
        this.springTemplateEngine = springTemplateEngine;
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("movies", moviesService.listAll());
        springTemplateEngine.process("listMovies.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movie = req.getParameter("selectedMovie");
        String person = req.getParameter("name");
        int numTicket = Integer.parseInt(req.getParameter("numTickets"));

        getServletContext().setAttribute("movie", movie);
        getServletContext().setAttribute("person", person);
        getServletContext().setAttribute("numTicket", numTicket);

        resp.sendRedirect("/ticketOrder");
    }
}
