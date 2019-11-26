package com.gitara.Inventory;

import java.util.*;
import java.util.Scanner;

public class Cinestar {
    private String cinestarName;
    private List<Projection> projections;

    public Cinestar(String cinestarName) {
        this.cinestarName = cinestarName;
        projections = new ArrayList<>();
    }

    public boolean reserveSeatForProjection(Customer customer, Projection projection, String seatNumber) {
        int projectionIndex = projections.indexOf(projection);
        return ((projectionIndex != -1) && (projections.get(projectionIndex).reserveSeat(customer, seatNumber)));
    }

    public boolean cancelSeatForProjection(Customer customer, Projection projection, String seatNumber) {
        int projectionIndex = projections.indexOf(projection);
        return ((projectionIndex != -1) && (projections.get(projectionIndex).cancelSeat(customer, seatNumber))); // JE LI BOLJE OVAKO ILI projections.get(movieIndex).accesRoom().cancelSeat(seatNumber);
    }


    public void seeProjectionChairsInfo (Projection wantedProjection) {
        int projectionIndex = projections.indexOf(wantedProjection);
        if (projectionIndex == -1) {
            System.out.println("Projection not found..");
            return;
        }
        switch (choiceForInfo()) {
            case 1:
                this.projections.get(projectionIndex).seeAvailableChairs();
                break;
            case 2:
                this.projections.get(projectionIndex).seeTakenChairs();
                break;
            case 3:
                this.projections.get(projectionIndex).seeAllChairs();
                break;
        }
    }

    public void seeAvailableProjections() {
        Iterator<Projection> it = projections.iterator();
        while(it.hasNext()) {
            Projection current = it.next();
            current.projectionInfo();
            if (current.movieInfo().hasMovieStarted()) {
                System.out.println("Time till movie starts -> ");
                current.printTimeTillStartOfProjection();
            }
            else
                System.out.println("Time till movie ends -> ");
                current.printTimeTillEndOfProjection();
            }
        }

    public boolean deleteOldProjections() {
        boolean oneToRemove = false;
        Iterator<Projection> it = projections.iterator();
        while(it.hasNext()) {
            Projection current = it.next();
            if (current.hasProjectionEnded()) {
                System.out.println("Deleting movie " + current.getMovieName());
                it.remove();
                oneToRemove = true;
            }
        }
    return oneToRemove;
    }

    public boolean addProjection(Projection newProjection) {
        if(!projections.contains(newProjection) && newProjection.projectionValidToAdd()) {
            System.out.println("Projection added succesfuly");
            projections.add(newProjection);
            return true;
        }
        System.out.println("Projection already exists or it is already started..");
    return false;
    }

    public boolean addProjection(CinemaRoom room, Movie movie, Time startTime, double ticketPrice) {
        ProjectionType projectionType = ProjectionType._3D;
        projectionType = projectionType.getType(chooseProjection());
        Projection newProjection = new Projection(room, movie, projectionType, startTime, ticketPrice);
        if (!projections.contains(newProjection)) {
            projections.add(newProjection);
            return true;
        }
            System.out.println("Projection already exists..");
    return false;
    }

    private int choiceForInfo() {
        System.out.println("1-See available places\n2-See taken places\n3-See all places");
    return scanner.nextInt();
    }

    private int chooseProjection() {
        System.out.println("Welcome..There are choices for you: ");
        System.out.println("1-Add premiere\n2-Add 3D movie\n3-Add 4D movie\n5-Add repetion\n6-Add opening week movie \n7-Add last 3 days movie");
        return scanner.nextInt();
    }

    private int findMovieIndex(Movie movie) {
        for (int i=0; i<projections.size(); i++) {
            if (movie.getMovieName().equalsIgnoreCase(projections.get(i).getMovieName()))
                return i;
        }
        System.out.println("Can't find movie you looking for..");
    return -1;
    }

private static Scanner scanner = new Scanner(System.in);

}
