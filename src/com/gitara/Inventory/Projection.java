package com.gitara.Inventory;


import java.util.ArrayList;
import java.util.List;

public class Projection {
    private CinemaRoom room;
    private Time movieStart;
    private Movie movie;
    private ProjectionType typeProjection;
    private Price ticketPrice;
    private List<Customer> soldTickets;


    public Projection(CinemaRoom room, Movie movie, ProjectionType typeProjection, Time movieStart, double regularPrice) {
        this.room = room;
        this.movie = movie;
        this.typeProjection = typeProjection;
        this.ticketPrice = new Price(typeProjection, regularPrice);
        this.movieStart = movieStart;
        this.soldTickets = new ArrayList<>();
    }

    public boolean stopProjection() {
        if (this.hasProjectionEnded()) {
            System.out.println(this.getMovieName() + " ended..");
            movie.stopMovie();
            return true;
        }
        System.out.println(this.getMovieName() + " isn't started or finished yet..");
        return false;
    }

    public boolean startProjection() {
        if (movieStart.movieEligibleForStart()) {
            System.out.println(this.getMovieName() + " is now starting..");
            movie.startMovie();
            return true;
        }
        System.out.println("Can't start movie named " + this.getMovieName());
        return false;
    }

    public boolean projectionValidToAdd() {
        return movieStart.movieValidForAdding();
    }

    public void printTimeTillEndOfProjection () {
        Time now = new Time();
        long secondsAfterMovieStart = this.movieStart.getSecondsAfterMovieStart(now);
        double movieDuration = this.movie.getMovieInfo().getMovieDurationSeconds();
        long newSeconds = (long) (movieDuration - secondsAfterMovieStart);
        if (secondsAfterMovieStart < 0)
            System.out.println("Movie hasn't started..");
        else {
            System.out.print("Time till end: ");
            int secondsTillEnd = (int) (newSeconds % 60);
            int hoursTillEnd = (int) (newSeconds / 60);
            int minutesTillEnd = hoursTillEnd % 60;
            hoursTillEnd/=60;
            System.out.println(String.format("%02d", hoursTillEnd) + ":"+
                    String.format("%02d", minutesTillEnd) + ":" +
                    String.format("%02d", secondsTillEnd));
        }
    }

    public void printTimeTillStartOfProjection() {
        Time now = new Time();
        long secondsMovieStart = Time.getCurrentTimeSeconds(this.movieStart);
        long newSeconds = secondsMovieStart - Time.getCurrentTimeSeconds(now);
        if (newSeconds < 0)
            System.out.println("Movie is started..");
        else {
            System.out.print("Time till start: ");
            int secondsTillStart = (int) (newSeconds % 60);
            int hoursTillStart = (int) (newSeconds / 60);
            int minutesTillStart = hoursTillStart % 60;
            hoursTillStart/=60;
            System.out.println(String.format("%02d", hoursTillStart) + ":"+
                    String.format("%02d", minutesTillStart) + ":" +
                    String.format("%02d", secondsTillStart));
        }
    }

    protected boolean hasProjectionEnded() {
        Time now = new Time();
        long secondsAfterMovieStart = this.movieStart.getSecondsAfterMovieStart(now);
        double movieDuration = this.movie.getMovieInfo().getMovieDurationSeconds();
        return secondsAfterMovieStart > movieDuration;
    }


    public boolean reserveSeat(Customer customer, String seatNumber) {
        if(customer.takeFromAccount(this.ticketPrice.getPrice()) && room.reserveSeat(seatNumber)) {
            System.out.println("Succesfuly reserved " + seatNumber + " on name " +
            customer.getCustomerName());
            soldTickets.add(customer);
            return true;
        }
        System.out.println(seatNumber + " isn't free or you don't have enough deposit on account..");
    return false;
    }


    public boolean cancelSeat(Customer customer, String seatNumber) {
        if(room.cancelSeat(seatNumber) && customer.addAmount(this.ticketPrice.getPrice() / 2)) {
            System.out.println("You succesfuly canceled reservation for " + seatNumber + " seat number!");
            System.out.println(this.ticketPrice.getPrice() / 2 + " succesfuly added to your account..");
            soldTickets.remove(customer);
            return true;
        }
        System.out.println("You can't cancel free seat..");
    return false;
    }

    public void seeTakenChairs() {
        this.room.seeTakenChairs();
    }

    public void seeAvailableChairs() {
        this.room.seeAvailableChairs();
    }

    public void seeAllChairs() {
        this.room.seeChairs();
    }


    public void projectionInfo() {
        System.out.println("Room " + room.getCinemaRoomNumber());
        System.out.println("Type projection: " +typeProjection.name());
        movie.movieInformation();
        System.out.print("Starting at -> ");
        movieStart.info();
    }

    public List<Customer> getSoldTickets() {
        return soldTickets;
    }

    public CinemaRoom accesCinemaRoom() {
        return room;
    }

    public Movie movieInfo() {
        return this.movie;
    }

    public String getMovieName() {
        return movie.getMovieName();
    }

}