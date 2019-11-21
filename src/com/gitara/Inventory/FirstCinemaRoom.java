package com.gitara.Inventory;


import java.util.List;
import java.util.Map;

public class FirstCinemaRoom extends CinemaRoom {
    boolean haveMoreMovies;

    public FirstCinemaRoom () {
        super(1,10, 3);
        haveMoreMovies = false;
    }

    public FirstCinemaRoom(int cinemaRoomNumber, int chairsNumber) {
        super(cinemaRoomNumber, 10, 3);
    }


    @Override
    public boolean addMovie(Movie movie) {
        haveMoreMovies = true;
        return super.addMovie(movie);
    }

    @Override
    public int getCinemaRoomNumber() {
        return super.getCinemaRoomNumber();
    }

    @Override
    public void setCinemaRoomNumber(int cinemaRoomNumber) {
        super.setCinemaRoomNumber(cinemaRoomNumber);
    }

    @Override
    public Map<String, Projection> getMovies() {
        return super.getMovies();
    }

}