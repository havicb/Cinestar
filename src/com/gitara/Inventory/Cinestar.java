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

    public boolean cancelSeat(Movie movie, String seatNumber) {
        int movieIndex = findMovieIndex(movie);
        if (movieIndex == -1)
            return false;
    return projections.get(movieIndex).cancelSeat(seatNumber);
    }

    public boolean reserveSeat(Movie movie, String seatNumber) {
        int movieIndex = findMovieIndex(movie);
        if (movieIndex == -1)
            return false;
    return projections.get(movieIndex).reserveSeat(seatNumber);
    }

    public void seeProjectionChairsInfo (Movie movie) {
        int movieIndex = findMovieIndex(movie);
        if (movieIndex == -1)
            return;
        switch (choiceForInfo()) {
            case 1:
                this.projections.get(movieIndex).seeAvailableChairs();
                break;
            case 2:
                this.projections.get(movieIndex).seeTakenChairs();
                break;
            case 3:
                this.projections.get(movieIndex).seeAllChairs();
                break;
        }
    }

    public void seeAvailableMovies() {
        Iterator<Projection> it = projections.iterator();
        while(it.hasNext()) {
            Projection current = it.next();
            current.projectionInfo();
            if (current.movieInfo().hasMovieStarted()) {
                System.out.println("Time till movie starts -> ");
                current.movieInfo().printTimeTillEndMovie();
            }
            else {
                System.out.println("Time till movie ends -> ");
                current.movieInfo().printTimeTillEndMovie();
            }
        }
    }

    public boolean deleteOldProjections() {
        boolean oneToRemove = false;
        Iterator<Projection> it = projections.iterator();
        while(it.hasNext()) {
            Projection current = it.next();
            if (current.movieValidForDeleting()) {
                System.out.println("Deleting movie " + current.getMovieName());
                it.remove();
                oneToRemove = true;
            }
        }
    return oneToRemove;
    }

    public boolean addProjection(CinemaRoom room, Movie movie, double ticketPrice) {
        ProjectionType projectionType = ProjectionType._3D;
        projectionType.getType(chooseProjection());
        Projection newProjection = new Projection(room, movie, projectionType, ticketPrice);
        if (!projections.contains(newProjection)) {
            projections.add(newProjection);
            return true;
        }
            System.out.println("Can't add projection..");
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
