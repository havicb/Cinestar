package com.gitara.Inventory;

// OSMISLIT CU OVAJ PROGRAM DA BUDE KAO ZAMJENA ZA SVE RADNIKE U KINU, TJ NE BI TREBALO RADNIKA VISE BIIT


import com.gitara.Inventory.Chairs;
import com.gitara.Inventory.CinemaRoom;
import com.gitara.Inventory.Movie;
import com.gitara.Inventory.ProjectionType;

public class Projection {
    private CinemaRoom room;
    private Movie movie;
    private Chairs chairs;
    private ProjectionType typeProjection;
    private Price ticketPrice;


    public Projection(CinemaRoom room, Movie movie, ProjectionType typeProjection, double regularPrice) {
        this.room = room;
        this.movie = movie;
        typeProjection = typeProjection;
        ticketPrice = new Price(typeProjection, regularPrice);
        chairs = new Chairs(this.room, room.getNumberRows(), room.getChairsPerRow());
    }

    public boolean cancelSeat(String seatNumber) {
        return chairs.cancelSeat(seatNumber);
    }

    public boolean reserveSeat(String seatNumber) {
        return chairs.reserveSeat(seatNumber);
    }

    public boolean startMovie() {
        return movie.startMovie();
    }

    public boolean stopMovie() {
        return movie.stopMovie();
    }

    public boolean movieValidForDeleting() {
        return movie.validStop();
    }

    public void seeTakenChairs() {
        this.chairs.seeTakenChairs();
    }

    public void seeAvailableChairs() {
        this.chairs.seeAvailableChairs();
    }

    public void seeAllChairs() {
        this.chairs.seeChairs();
    }


    public void projectionInfo() {
        System.out.println("Room " + room.getCinemaRoomNumber());
        System.out.println("Type projection: " +typeProjection.name());
        movie.movieInformation();
    }

    public Movie movieInfo() {
        return this.movie;
    }

    public String getMovieName() {
        return movie.getMovieName();
    }

}