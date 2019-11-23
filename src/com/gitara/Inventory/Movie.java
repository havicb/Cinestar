package com.gitara.Inventory;


import java.util.List;

public class Movie {
    private Time movieStart;
    private MovieSpecification movieInfo;
    private boolean started;

    public Movie(String movieName, int duration, String director, List<Genre> genres, Time startMovie) {
        this(new MovieSpecification(movieName, duration, director, genres), startMovie);
    }

    public Movie(MovieSpecification movieInfo, Time startMovie) {
        this.movieInfo = movieInfo;
        movieStart = startMovie;
    }

    public boolean stopMovie() {
        if (validStop()) {
            System.out.println(this.getMovieName() + " ended..");
            started = false;
            return true;
        }
        System.out.println(this.getMovieName() + " isn't started or finished yet..");
        return false;
    }

    public boolean startMovie() {
        if (!started && movieStart.movieEligibleForStart()) {
            System.out.println(this.getMovieName() + " is now starting..");
            started = true;
            return true;
        }
        System.out.println("Can't start movie named " + this.getMovieName());
        return false;
    }

    public void printTimeTillEndMovie () {
        Time now = new Time();
        long secondsAfterMovieStart = this.getMovieStart().getSecondsAfterMovieStart(now);
        double movieDuration = this.movieInfo.getMovieDurationSeconds();
        long newSeconds = (long) (movieDuration - secondsAfterMovieStart);
        if (newSeconds < 0)
            System.out.println("Movie is finished..");
        else {
            System.out.println("Time till end: ");
            int secondsTillEnd = (int) (newSeconds % 60);
            int hoursTillEnd = (int) (newSeconds / 60);
            int minutesTillEnd = hoursTillEnd % 60;
            hoursTillEnd/=60;
            System.out.println(String.format("%02d", hoursTillEnd) + ":"+
                    String.format("%02d", minutesTillEnd) + ":" +
                    String.format("%02d", secondsTillEnd));
        }
    }

    public void printTimeTillStartMovie () {
        Time now = new Time();
        long secondsMovieStart = Time.getCurrentTimeSeconds(this.movieStart);
        long newSeconds = secondsMovieStart - Time.getCurrentTimeSeconds(now);
        if (newSeconds < 0)
            System.out.println("Movie is started..");
        else {
            System.out.println("Time till start: ");
            int secondsTillStart = (int) (newSeconds % 60);
            int hoursTillStart = (int) (newSeconds / 60);
            int minutesTillStart = hoursTillStart % 60;
            hoursTillStart/=60;
            System.out.println(String.format("%02d", hoursTillStart) + ":"+
                    String.format("%02d", minutesTillStart) + ":" +
                    String.format("%02d", secondsTillStart));
        }
    }

    protected boolean validStop() {
            Time now = new Time();
        long secondsAfterMovieStart = this.getMovieStart().getSecondsAfterMovieStart(now);
        double movieDuration = this.movieInfo.getMovieDurationSeconds();
        return secondsAfterMovieStart > movieDuration;
    }

    public Time getMovieStart() {
        return movieStart;
    }

    public void movieInformation() {
        System.out.println("**************");
        movieInfo.movieSpecInfo();
        System.out.print("MOVIE STARTING -> ");
        movieStart.info();
        System.out.println("Started -> " + started);
    }

    public boolean hasMovieStarted() {
        return started;
    }

    public MovieSpecification getMovieInfo() {
        return movieInfo;
    }

    public String getMovieName() {
        return movieInfo.getMovieName();
    }



}

