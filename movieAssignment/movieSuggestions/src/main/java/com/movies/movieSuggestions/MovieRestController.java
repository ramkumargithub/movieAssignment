package com.movies.movieSuggestions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
public class MovieRestController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public List<MovieDetails> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{genre}")
    public ResponseEntity<MovieDetails> getMoviesByGenre(@PathVariable("genre") String genre){

        MovieDetails movie = movieService.getMovieByGenre(genre);
        if(null == movie){
            return new ResponseEntity<MovieDetails> (HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<MovieDetails> (movie, HttpStatus.OK);
    }
}
