package mk.finki.ukim.mk.lab1.repository;


import mk.finki.ukim.mk.lab1.model.Movie;
import mk.finki.ukim.mk.lab1.model.TicketOrder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository{
    private List<Movie> movies = new ArrayList<>();

    public MovieRepository() {
        movies.add(new Movie("Movie 1", "Summary 1", 8.5));
        movies.add(new Movie("Movie 2", "Summary 2", 7.9));
        movies.add(new Movie("Movie 3", "Summary 3", 6.5));
        movies.add(new Movie("Movie 4", "Summary 4", 9.0));
        movies.add(new Movie("Movie 5", "Summary 5", 7.2));
        movies.add(new Movie("Movie 6", "Summary 6", 8.1));
        movies.add(new Movie("Movie 7", "Summary 7", 7.8));
        movies.add(new Movie("Movie 8", "Summary 8", 8.7));
        movies.add(new Movie("Movie 9", "Summary 9", 6.9));
        movies.add(new Movie("Movie 10", "Summary 10", 7.5));
    }

    public List<Movie> searchMovies(String text){
        return movies.stream().filter(r->r.getTitle().contains(text)||r.getSummary().contains(text)).collect(Collectors.toList());
    }
    public List<Movie> listAll() {
        return movies;
    }

}
