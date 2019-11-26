package com.gitara.Inventory;

import java.util.ArrayList;
import java.util.List;

public final class MovieSpecification {
    private final String movieName;
    private final String director;
    private final int movieDuration;
    private List<Genre> genres;

    public MovieSpecification(String movieName, int movieDuration, String director, List<Genre> genres) {
        this.movieName = movieName;
        this.movieDuration = movieDuration;
        this.genres = new ArrayList<>();
        this.director = director;
        addGenres(genres);
    }

    private void addGenres (List<Genre> genres) {
        this.genres.addAll(genres);
    }

    public double getMovieDurationSeconds () {
        return (movieDuration % 60) + (movieDuration/60);
    }

    public void movieSpecInfo () {
        System.out.println("Movie name -> " + movieName);
        System.out.println("Movie director -> " + director);
        System.out.println("Duration -> " + movieDuration + " min");
        System.out.println(genres.toString());
    }

    public String getMovieName () {
        return movieName;
    }

    public int getDuration() {
        return movieDuration;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getDirector() {
        return director;
    }

}