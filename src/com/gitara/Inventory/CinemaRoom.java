package com.gitara.Inventory;


import java.time.LocalDateTime;
import java.util.*;

public class CinemaRoom {
    private int cinemaRoomNumber;
    private int chairsNumber;
    private int chairsPerRow;
    private int numberOfRows;
    private Chair [] chairs;

    public CinemaRoom(int cinemaRoomNumber, int chairsPerRow, int numberOfRows) {
        this.cinemaRoomNumber = cinemaRoomNumber;
        this.chairsNumber = chairsPerRow * numberOfRows;
        this.chairsPerRow = chairsPerRow;
        this.numberOfRows = numberOfRows;
        chairs = new Chair[numberOfRows * chairsPerRow];
        this.inicijalizirajRedove(numberOfRows, chairsPerRow);
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

    public void seeChairs () {
        System.out.println("All available chairs: ");
        for (Chair current : chairs)
            current.info();
    }

    public void seeTakenChairs () {
        System.out.println("Next seats are taken..");
        for (Chair current : chairs) {
            if (!current.isFree())
                current.info();
        }
    }

    public void seeAvailableChairs () {
        System.out.println("Next seats are free..");
        for (Chair current : chairs) {
            if (current.isFree())
                current.info();
        }
    }

    private int findSeat (String seatNum) {
        for (int i=0; i<chairs.length; i++) {
            if (seatNum.equalsIgnoreCase(chairs[i].getChairNum()))
                return i;
        }
        return -1;
    }

    private void inicijalizirajRedove (int numRows, int chairsPerRow) {
        int lastRow = 'A' + numRows;
        int temp = 0;
        double price;
        for (char row ='A'; row < lastRow; row++) {
            for (int i = 0; i < chairsPerRow; i++)
                chairs[temp++] = new Chair(row + Integer.toString(i+1), 0.00);
        }
    }

    public int getCinemaChairsNumber() {
        return this.chairsNumber;
    }

    public int getCinemaRoomNumber() {
        return cinemaRoomNumber;
    }

    public int getChairsNumber() {
        return chairsNumber;
    }

    public int getChairsPerRow() {
        return chairsPerRow;
    }

    public int getNumberRows() {
        return numberOfRows;
    }


}