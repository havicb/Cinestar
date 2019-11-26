package com.gitara.Inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Customer belmin = new Customer("Belmin", 10);
        Time vecersPola9 = new Time(25, 20, 30);
        Time vecerasPola10 = new Time(25, 21, 30);
        Time sutraPola9 = new Time(26, 20, 30);
        Time sutraPola10 = new Time(26, 21, 30);
        ArrayList<Genre> genreGDD = new ArrayList<>();
        genreGDD.add(Genre.Action);
        genreGDD.add(Genre.Comedy);
        Movie GasDoDaske = new Movie("Gas Do Daske", 90, "Spilberg", genreGDD);
        CinemaRoom prva = new CinemaRoom(1, 10, 3);
        Projection nova = new Projection(prva, GasDoDaske, ProjectionType.Premiere, vecerasPola10, 5.00);
        Cinestar bcc = new Cinestar("BCC");
        bcc.addProjection(nova);
        bcc.reserveSeatForProjection(belmin, nova, "B3");
        System.out.println(Arrays.toString(nova.getSoldTickets().toArray()));
        bcc.cancelSeatForProjection(belmin, nova, "B3");
        bcc.cancelSeatForProjection(belmin, nova, "C4");
        nova.printTimeTillStartOfProjection();
        bcc.seeProjectionChairsInfo(nova);
        belmin.accountInfo();
    }

}




/*

    CinemaRoom nmbr1 = new CinemaRoom(1,10, 3);
        nmbr1.addMovie(a);
        nmbr1.addMovie(b);
        nmbr1.addMovie(c);
        nmbr1.addMovie(d);
        nmbr1.addMovie(e);
        nmbr1.seeMovies();
 */