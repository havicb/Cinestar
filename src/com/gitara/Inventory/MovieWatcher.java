package com.gitara.Inventory;

public class MovieWatcher {
    private String name;
    private Account deposit;

    public MovieWatcher() {
        this(" ", 0);
    }

    public MovieWatcher(String name) {
        this(name, 0);
    }

    public MovieWatcher(double amount) {
        this(" ", amount);
    }

    public MovieWatcher(String name, double amount) {
        this.name = name;
        deposit = new Account(amount);
    }

    public boolean addAmount (double amount) {
        return deposit.addAmount(amount);
    }

    public void accountInfo() {
        if(!this.name.equals(" "))
            System.out.println("Name: " + this.name);
        deposit.accountInfo();
    }



}
