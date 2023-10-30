package mk.finki.ukim.mk.lab1.service;

import mk.finki.ukim.mk.lab1.model.Movie;
import mk.finki.ukim.mk.lab1.repository.MovieRepository;

import java.util.List;

public interface MovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text);
}