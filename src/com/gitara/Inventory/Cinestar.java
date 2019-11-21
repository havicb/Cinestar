package com.gitara.Inventory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cinestar {
    private String cinestarName;
    private Map<Integer, CinemaRoom> cinemaRooms;

    public Cinestar (String cinestarName) {
        this.cinestarName = cinestarName;
        cinemaRooms = new HashMap<>();
    }

    public boolean addMovie (CinemaRoom cinemaRoom, Movie movie) {
        if (cinemaRooms.containsValue(cinemaRoom))
            return cinemaRooms.get(cinemaRoom.getCinemaRoomNumber()).addMovie(movie);
        System.out.println("We can't find room number " + cinemaRoom.getCinemaRoomNumber());
    return false;
    }

    public boolean startMovie (CinemaRoom cinemaRoom, Movie movie) {
        if (cinemaRooms.containsValue(cinemaRoom)) {
            cinemaRooms.get(cinemaRoom.getCinemaRoomNumber()).startMovie(movie.getMovieName());
            return true;
        }
        System.out.println("Can't find wanted cinema room..");
    return false;
    }

    public void removeMoviesForCinemaRoom (CinemaRoom cinemaRoom) {
        cinemaRoom.deleteOldMovies();
    }

    public void removeAllOldMovies () {
        Iterator<CinemaRoom> it = cinemaRooms.values().iterator();
        while (it.hasNext()) {
            CinemaRoom current = it.next();
            current.deleteOldMovies();
        }
    }

    public boolean addCinemaRoom (CinemaRoom nova) {
        if (!cinemaRooms.containsValue(nova)) {
            System.out.println("You succesfuly added new room to cinestar..");
            cinemaRooms.put(nova.getCinemaRoomNumber(), nova);
            return true;
        }
        System.out.println("Room is already added..");
    return false;
    }

    public void startMovies () {
        Iterator<CinemaRoom> it = cinemaRooms.values().iterator();
        while (it.hasNext()) {
            CinemaRoom current = it.next();
            current.tryStartAllMovies();
        }
    }

    public void printChairsForMovie (CinemaRoom cinemaRoom, Movie movie) {
        if (cinemaRooms.containsValue(cinemaRoom))
            cinemaRooms.get(cinemaRoom.getCinemaRoomNumber()).seeChairs(movie.getMovieName());
    }

    public void printMoviesForCinemaRoom (CinemaRoom cinemaRoom) {
        cinemaRoom.seeMovies();
    }


}
