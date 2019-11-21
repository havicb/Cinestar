package com.gitara.Inventory;


import java.time.LocalDateTime;
import java.util.*;

public abstract class CinemaRoom {
    private int cinemaRoomNumber, chairsNumber, chairsPerRow, numRows;
    private Map<String, Projection> movies;
    private boolean doorOpened;

    public CinemaRoom(int cinemaRoomNumber, int chairsPerRow, int numRows) {
        this.cinemaRoomNumber = cinemaRoomNumber;
        this.movies = new HashMap<>();
        this.chairsNumber = chairsPerRow * numRows;
        this.doorOpened = false;
        this.chairsPerRow = chairsPerRow;
        this.numRows = numRows;
    }

    public boolean deleteOldMovies () {
        Iterator<Map.Entry<String, Projection>> it = movies.entrySet().iterator();
        boolean oneToRemove = false;
        while (it.hasNext()) {
            Map.Entry<String, Projection> current = it.next();
            if (current.getValue().deleteOldMovie()) {
                System.out.println("Removing.. " + current.getKey());
                it.remove();
                oneToRemove = true;
            }
        }
        if(!oneToRemove)
            System.out.println("There is no movies for deleting..");
        return oneToRemove;
    }

    public void seeMovies () {
        System.out.println("Next movies are available to watch..");
        Iterator<Map.Entry<String, Projection>> it = movies.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, Projection> current = it.next();
            current.getValue().info();
        }
    }

    public void seeMovieInfo (String movieName) {
        if (movies.containsKey(movieName)) {
            movies.get(movieName).seeChairs();
            return;
        }
        System.out.println("There is no movie named " + movieName);
    }

    public void seeChairs (String movieName) {
        if (movies.containsKey(movieName)) {
            movies.get(movieName).seeChairs();
            return;
        }
        System.out.println("We can't find movie you looking for..");
    }

    public boolean startMovie (String movieName) {
        return movies.get(movieName).startMovie();
    }

    public boolean stopMovie (String movieName) {
        return movies.get(movieName).stopMovie();
    }

    public void seeAvailableChairs (String movieName) {
        movies.get(movieName).seeAvailableChairs();
    }

    public void seeTakenChairs (String movieName) {
        movies.get(movieName).seeTakenChairs();
    }

    public boolean reserveSeat (String movieName, String seatNumber) {
        if (movies.containsKey(movieName))
            return movies.get(movieName).reserveSeat(seatNumber);
        System.out.println("Can't find movie you looking for..");
        return false;
    }

    public boolean cancelSeat (String movieName, String seatNumber) {
        if (movies.containsKey(movieName)) {
            return movies.get(movieName).cancelSeat(seatNumber);
        }
        System.out.println("Can't find movie you looking for..");
        return false;
    }

    public boolean addMovie (Movie movie) {
        if (!movies.containsKey(movie.getMovieName())) {
            movies.put(movie.getMovieName(), new Projection(this, movie));
            System.out.println(movie.getMovieName() + " added succesfuly");
            return true;
        }
        System.out.println(movie.getMovieName() + " already added");
        return false;
    }

    public int numMovies () {
        return movies.size();
    }

    public int getCinemaChairsNumber () {
        return this.chairsNumber;
    }

    public int getCinemaRoomNumber() {
        return cinemaRoomNumber;
    }

    public void setCinemaRoomNumber(int cinemaRoomNumber) {
        this.cinemaRoomNumber = cinemaRoomNumber;
    }

    public int getChairsNumber() {
        return chairsNumber;
    }

    public int getChairsPerRow() {
        return chairsPerRow;
    }

    public int getNumRows() {
        return numRows;
    }

    public boolean isDoorOpened() {
        return doorOpened;
    }

    public Map<String, Projection> getMovies() {
        return movies;
    }

}