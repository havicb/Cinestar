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

    public void info() {
        System.out.println("*********************");
        System.out.println("Chair -> " + chairNum);
        System.out.println("Price -> " + price);
        System.out.println("Free -> " + isFree);
    }

    public boolean cancelSeat() {
        if (isFree)
            return false;
        isFree = true;
    return true;
    }

    public boolean reserveSeat() {
        if (!isFree)
            return false;
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
