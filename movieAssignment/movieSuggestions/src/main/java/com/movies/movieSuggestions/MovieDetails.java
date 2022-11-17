package com.movies.movieSuggestions;

/**
 *
 */

public class MovieDetails {

    private int id;
    private String movieName;
    private String releaseDate;
    private String genre;

    public MovieDetails(int id, String movieName, String releaseDate, String genre) {
        this.id = id;
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
