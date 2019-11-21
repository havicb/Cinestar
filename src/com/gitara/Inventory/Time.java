package com.gitara.Inventory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Comparator;

public class Time {
    LocalDateTime currentTime;


    public Time (int day, int hours, int minutes) { // ASSUMING YOU CAN ADD JUST MOVIES FOR THIS AND NEXT MONTH
        LocalDate today = LocalDate.now();
        currentTime = LocalDateTime.of(today.getYear(), today.getMonth(), day, hours, minutes, 0);
    }

    public Time() {
        currentTime = LocalDateTime.now();
    }

    public void oduzmiOd (int hours, int minutes, int seconds) {
        int newHours = getHours() - hours;
        int newMinutes = getMinutes() - minutes;
        int newSeconds = getSeconds() - seconds;
        LocalDate today = LocalDate.now();
        LocalDateTime novo = LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), newHours, newMinutes, newSeconds);
        currentTime = novo;
    }

    private long getCurrentTimeSeconds () {
        long seconds = 0;
        seconds+=currentTime.getSecond();
        seconds+=currentTime.getMinute() * 60;
        seconds+=currentTime.getHour() * 3600;
        return seconds;
    }

    private int getDay () {
        return currentTime.getDayOfMonth();
    }

    protected boolean isAfterNow () {
        LocalDateTime sadasnjeVrijeme = LocalDateTime.now();
        return currentTime.isAfter(sadasnjeVrijeme);
    }

    protected boolean isBeforeNow () {
        LocalDateTime sadasnjeVrijeme = LocalDateTime.now();
        return currentTime.isBefore(sadasnjeVrijeme);
    }

    public boolean equalNow () {
        LocalDateTime sadasnjeVrijeme = LocalDateTime.now();
        return ((sadasnjeVrijeme.getHour() == currentTime.getHour()) && (sadasnjeVrijeme.getMinute() == currentTime.getMinute())
                && (sadasnjeVrijeme.getSecond() == currentTime.getSecond()));
    }

    public boolean timeForStart () {
        Time now = new Time();
        if (currentTime.getHour() > now.getHours())
            return false;
        else if ((currentTime.getHour() == now.getHours()) && (currentTime.getMinute() < now.getMinutes()))
            return true;
        else if (currentTime.getHour() <= now.getHours() && !this.krajVremena())
            return true;
        return false;
    }

    public boolean krajVremena () { //CURRENT TIME IS TIME WHEN MOVIE IS STARTING OR STARTED
        Time now = new Time();
        if (currentTime.getDayOfMonth() < now.getDay())
            return true;
        if ((currentTime.getHour() - now.getHours() < 0) && (currentTime.getMinute() - now.getMinutes() < 0))
            return true;
        long moviesSeconds = this.getCurrentTimeSeconds(); // IMAM SEKUNDE VREMENA KREIRANOG FILMA TIPA 21:30
        long secondsNow = now.getCurrentTimeSeconds(); // SEKUNDE VREMENA SADA
        if (moviesSeconds < secondsNow && currentTime.getDayOfMonth() == now.getDay())
            return true;
        return false;
    }

    public int getHours() {
        return currentTime.getHour();
    }

    public int getMinutes() {
        return currentTime.getMinute();
    }

    public int getSeconds() {
        return currentTime.getSecond();
    }

    public void info () {
        System.out.println(getHours() + ":" + getMinutes() + ":" + getSeconds());
    }

}
