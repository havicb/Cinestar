package com.gitara.Inventory;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
       /* Time danasPola9 = new Time(21, 20, 30);
        Time danasPola10 = new Time(21, 21, 30);
        Time sutraPola9 = new Time(21, 20, 30);
        Time sutraPola10 = new Time(21, 21, 30);
        Movie a = new Movie("Gas do daske", "1:35", "Spilberg", Genre.COMEDY, danasPola9);
        Movie b = new Movie("Nun", "2:05", "Beli", Genre.HORROR,  danasPola10);
        Movie c = new Movie("Glup i gluplji", "1:40", "Reditelj", Genre.COMEDY, sutraPola9);
        Movie d = new Movie("21 jump street", "1:55", "Jonah Hill", Genre.COMEDY, sutraPola9);
        Movie e = new Movie("22 jump street", "2:05", "Jonah Hill", Genre.COMEDY, sutraPola10);
        CinemaRoom firstRoom = new CinemaRoom(1, 10, 3);
        CinemaRoom secondRoom = new CinemaRoom (2, 15, 2);
        Cinestar bcc = new Cinestar("Bingo City Cinestar");
        bcc.addCinemaRoom(firstRoom);
        bcc.addCinemaRoom(secondRoom);
        bcc.addMovie(firstRoom, a);
        bcc.addMovie(firstRoom, b);
        bcc.addMovie(firstRoom, c);
        bcc.addMovie(secondRoom, d);
        bcc.addMovie(secondRoom, e);
        bcc.printMoviesForCinemaRoom(secondRoom);
*/
       MovieWatcher novi = new MovieWatcher(-5);
       novi.addAmount(10);
        novi.accountInfo();



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