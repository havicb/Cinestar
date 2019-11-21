package com.gitara.Inventory;

import java.util.HashMap;
import java.util.Map;

public class Cinestar {
    private String cinestarName;
    private Map<CinemaRoom, String> cRooms;

    public Cinestar (String cinestarName) {
        this.cinestarName = cinestarName;
        cRooms = new HashMap<>();
    }

    public void addRoom (CinemaRoom nova, String name) {
        if (!cRooms.containsKey(nova)) {
            System.out.println("You succesfuly added new room to cinestar..");
            cRooms.put(nova, name);
        }
        else
            System.out.println("Room is already added..");
    }





}
