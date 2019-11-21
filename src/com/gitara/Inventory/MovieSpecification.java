package com.gitara.Inventory;

import java.util.ArrayList;
import java.util.List;

public final class MovieSpecification {
    private final String movieName, duration, director;
    private final Genre genre;

    public MovieSpecification(String movieName, String duration, String director, Genre genre) {
        this.movieName = movieName;
        this.duration = duration;
        this.genre = genre;
        this.director = director;
    }

    public double getMovieDurationSeconds () {
        String [] parts = duration.split(":");
        double sekunde = 0; int vrijednost = 3600;
        for (String current : parts) {
            sekunde += Double.parseDouble(current) * vrijednost;
            vrijednost/=60;
        }
        return sekunde;
    }

    public void movieSpecInfo () {
        System.out.println("Movie name -> " + movieName);
        System.out.println("Movie director -> " + director);
        System.out.println("Duration -> " + duration);
        System.out.println(genre.toString());
    }

    public String getMovieName () {
        return movieName;
    }

    public String getDuration() {
        return duration;
    }

    public Genre getGenre() {
        return genre;
    }


    public String getDirector() {
        return director;
    }

}