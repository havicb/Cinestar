package com.gitara.Inventory;

public class Chair {
    private String chairNum;
    private double price;
    private boolean isFree;


    public Chair(String chairNum, double price) {
        this.chairNum = chairNum;
        this.price = price;
        this.isFree = true;
    }

    public void info () {
        System.out.println("*********************");
        System.out.println("Chair -> " + chairNum);
        System.out.println("Price -> " + price);
        System.out.println("Free -> " + isFree);
    }

    public boolean cancelSeat () {
        if (isFree) {
            System.out.println(chairNum + " is arleady free");
            return false;
        }
        System.out.println("You succesfully canceled seat " + chairNum);
        isFree = true;
        System.out.println("Seat " + chairNum + " is now untaken..");
        return true;
    }

    public boolean reserveSeat () {
        if (!isFree) {
            System.out.println(chairNum + " is already taken..");
            return false;
        }
        System.out.println("You succesfully reserved seat " + chairNum);
        isFree = false;
        return true;
    }

    public String getChairNum() {
        return chairNum;
    }

    public boolean isFree() {
        return isFree;
    }

    public double getPrice() {
        return price;
    }


}
