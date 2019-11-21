package com.gitara.Inventory;

public class Projection {
    CinemaRoom cinema;
    Movie movie;
    Chair [] chairs;
    int temp = 0;

    public Projection (CinemaRoom cinema, Movie movie) {
        this.cinema = cinema;
        this.movie = movie;
        this.chairs = new Chair[cinema.getCinemaChairsNumber()];
        this.inicijalizirajRedove(cinema.getNumRows(), cinema.getChairsPerRow());
    }

    protected boolean startMovie () {
        return movie.startMovie();
    }

    protected boolean stopMovie () {
        return movie.stopMovie();
    }

    protected boolean deleteOldMovie () {
        return movie.validRemoving();
    }

    private void inicijalizirajRedove (int numRows, int chairsPerRow) {
        int lastRow = 'A' + numRows;
        double price;
        for (char row ='A'; row < lastRow; row++) {
            for (int i = 0; i < chairsPerRow; i++) {
                Chair nova = new Chair(row + Integer.toString(i+1), 0.00);
                chairs[temp++] = nova;
            }
        }
    }

    public boolean cancelSeat (String seatNumber) {
        int seatNum = findSeat(seatNumber);
        if (seatNum == -1) {
            System.out.println("Can't find seat..");
            return false;
        }
        return chairs[seatNum].cancelSeat();
    }

    public boolean reserveSeat (String seatNumber) {
        int seatNum = findSeat(seatNumber);
        if (seatNum == -1) {
            System.out.println("Can't find seat..");
            return false;
        }
        return chairs[seatNum].reserveSeat();
    }

    private int findSeat (String seatNum) {
        for (int i=0; i<chairs.length; i++) {
            if (seatNum.equalsIgnoreCase(chairs[i].getChairNum()))
                return i;
        }
        return -1;
    }

    public void seeChairs () {
        System.out.println("All available chairs: ");
        for (Chair current : chairs)
            current.info();
    }

    public void seeTakenChairs () {
        System.out.println("Next seats are taken..");
        for (Chair current : chairs) {
            if (current.isTaken())
                current.info();
        }
    }

    public void seeAvailableChairs () {
        System.out.println("Next seats are free..");
        for (Chair current : chairs) {
            if (!current.isTaken())
                current.info();
        }
    }

    public void info () {
        movie.movieInformation();
    }

    public String getMovieName () {
        return movie.getMovieName();
    }

}