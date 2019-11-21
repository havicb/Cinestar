package com.gitara.Inventory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Comparator;

public class Time {
    LocalDateTime currentTime;


    public Time (int day, int hours, int minutes) { // ASSUMING YOU CAN ADD JUST MOVIES FOR THIS MONTH
        LocalDate today = LocalDate.now();
        currentTime = LocalDateTime.of(today.getYear(), today.getMonth(), day, hours, minutes, 0);
    }

    public Time() {
        currentTime = LocalDateTime.now();
    }

    // FILM POCEO 14:30 //
    // SAD JE 15:58 //

    public boolean movieEligibleForStart () { // YOU CAN START MOVIE 15 min before or after real movie time //
        Time now = new Time(); // KREIRA VRIJEME SADA //
        return eligibleTimeForStart(now);
    }

    private boolean eligibleTimeForStart (Time now) {
        return (eligibleMinutesForStart(now) && eligibleHoursAndSecondsForStart(now));
    }

    private boolean eligibleHoursAndSecondsForStart (Time now) {
        return currentTime.minusHours(now.getHours()).getHour() == 0;
    }

    private boolean eligibleMinutesForStart (Time now) {
            int minutes = currentTime.minusMinutes(now.getMinutes()).getMinute();
        return  minutes >= -15 && minutes <= 15;
    }

    protected long getSecondsAfterMovieStart (Time now) {
        long secondsNow = getCurrentTimeSeconds(now); //
        long secondsMovieStart = getCurrentTimeSeconds(new Time(currentTime.getDayOfMonth(), currentTime.getHour(), currentTime.getMinute()));
        return secondsNow - secondsMovieStart;
    }

    protected static long getCurrentTimeSeconds (Time some) {
        long seconds = 0;
        seconds+=some.getSeconds();
        seconds+=some.getMinutes() * 60;
        seconds+=some.getHours() * 3600;
        return seconds;
    }

    private int getDay () {
        return currentTime.getDayOfMonth();
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
        System.out.println(String.format("%02d", getHours()) + ":" +
                String.format("%02d", getMinutes()) + ":" +
                String.format("%02d", getSeconds()));
    }

}
