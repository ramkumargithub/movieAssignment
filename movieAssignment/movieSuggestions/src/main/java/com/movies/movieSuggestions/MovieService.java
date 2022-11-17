package com.movies.movieSuggestions;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 */
@Service
public class MovieService {

    public List<MovieDetails> getAllMovies(){
        List<MovieDetails> listOfMovies = new ArrayList<>();
        
        listOfMovies.add(new MovieDetails(1, "God Father", "29-09-1972", "Classic"));
        listOfMovies.add(new MovieDetails(2, "Finding Nemo", "28-11-2003", "Animation"));
        listOfMovies.add(new MovieDetails(1, "The Shawshank Redemption", "24-02-1995", "Thriller"));

        return listOfMovies;
    }

    public MovieDetails getMovieByGenre(String genre) {
        Predicate<MovieDetails> byGenre = m -> m.getGenre().equals(genre);
        return filterMovies(byGenre);
    }

    private MovieDetails filterMovies(Predicate<MovieDetails> genre){
        return getAllMovies().stream().filter(genre).findAny().orElse(null);
    }
}


