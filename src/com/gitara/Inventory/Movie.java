package com.gitara.Inventory;


import java.util.List;

public class Movie {
    private MovieSpecification movieInfo;
    private boolean hasStarted;

    public Movie(String movieName, int duration, String director, List<Genre> genres) {
        this(new MovieSpecification(movieName, duration, director, genres));
    }

    public Movie(MovieSpecification movieInfo) {
        this.movieInfo = movieInfo;
    }

    public void stopMovie() {
        if(hasStarted)
            hasStarted = false;
    }

    public void startMovie() {
        if(!hasStarted)
            hasStarted = true;
    }

    public void movieInformation() {
        System.out.println("**************");
        movieInfo.movieSpecInfo();
        System.out.println("Started -> " + hasStarted);
    }

    public boolean hasMovieStarted() {
        return hasStarted;
    }

    public MovieSpecification getMovieInfo() {
        return movieInfo;
    }

    public String getMovieName() {
        return movieInfo.getMovieName();
    }

}

