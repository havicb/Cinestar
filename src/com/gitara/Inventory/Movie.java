package com.gitara.Inventory;


public class Movie {
    private Time movieStart;
    private MovieSpecification movieInfo;
    private double ticketPrice;
    private boolean isRecording;

    public Movie(String movieName, String duration, String director, Genre genre, Time startMovie) {
        this(new MovieSpecification(movieName, duration, director, genre), startMovie);
    }

    public Movie(MovieSpecification movieInfo, Time startMovie) {
        this.movieInfo = movieInfo;
        this.ticketPrice = 0.00;
        movieStart = startMovie;
    }

    protected boolean movieStarted() {
        return isRecording;
    }

    public boolean validRemoving() {
        return movieStart.krajVremena();
    }

    protected boolean stopMovie() {
        if (isRecording && validStop()) {
            System.out.println(this.getMovieName() + " ended..");
            isRecording = false;
            return true;
        }
        System.out.println(this.getMovieName() + " isn't started or finished yet..");
        return false;
    }

    public String getMovieName() {
        return movieInfo.getMovieName();
    }

    private Time getTimeNow() {
        return new Time();
    }

    private boolean validStop() {
        return this.getMovieStart().krajVremena();
    }

    private boolean validStart() {
        return movieStart.timeForStart();
    }

    public boolean startMovie() {
        if (!isRecording && validStart()) {
            System.out.println(this.getMovieName() + " is now starting..");
            isRecording = true;
            return true;
        }
        System.out.println("Can't start movie called " + this.getMovieName());
        return false;
    }

    public Time getMovieStart() {
        return movieStart;
    }

    public void movieInformation() {
        System.out.println("**************");
        movieInfo.movieSpecInfo();
        System.out.print("Movie starting -> ");
        movieStart.info();
        System.out.println("Regular ticket price ->" + ticketPrice);
        System.out.println("Started -> " + isRecording);
    }

    public MovieSpecification getMovieInfo() {
        return movieInfo;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

}