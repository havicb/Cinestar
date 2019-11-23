package com.gitara.Inventory;


import java.time.LocalDateTime;
import java.util.*;

public class CinemaRoom {
    private int cinemaRoomNumber;
    private int chairsNumber;
    private int chairsPerRow;
    private int numberOfRows;

    public CinemaRoom(int cinemaRoomNumber, int chairsPerRow, int numberOfRows) {
        this.cinemaRoomNumber = cinemaRoomNumber;
        this.chairsNumber = chairsPerRow * numberOfRows;
        this.chairsPerRow = chairsPerRow;
        this.numberOfRows = numberOfRows;
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