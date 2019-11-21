package com.gitara.Inventory;

public class Chair {
    private String chairNum;
    private double price;
    private boolean isTaken;


    public Chair(String chairNum, double price) {
        this.chairNum = chairNum;
        this.price = price;
        this.isTaken = false;
    }

    public void info () {
        System.out.println("**********************");
        System.out.println("Chair -> " + chairNum);
        System.out.println("Price -> " + price);
        System.out.println("Free -> " + !isTaken);
    }

    public boolean cancelSeat () {
        if (!isTaken) {
            System.out.println(chairNum + " is arleady free");
            return false;
        }
        System.out.println("You succesfully canceled seat " + chairNum);
        isTaken = false;
        System.out.println("Seat " + chairNum + " is now untaken..");
        return true;
    }

    public boolean reserveSeat () {
        if (isTaken) {
            System.out.println(chairNum + " is already taken..");
            return false;
        }
        System.out.println("You succesfully reserved seat " + chairNum);
        isTaken = true;
        return true;
    }

    public String getChairNum() {
        return chairNum;
    }

    public void setChairNum(String chairNum) {
        this.chairNum = chairNum;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
