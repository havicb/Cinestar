package com.gitara.Inventory;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private Account deposit;
    private List<Projection> projectionsToWatch;
    private List<Projection> watchedProjections;

    public Customer(String name) {
        this(name, 0);
    }


    public Customer(String name, double amount) {
        this.name = name;
        deposit = new Account(amount);
        projectionsToWatch = new ArrayList<>();
        watchedProjections = new ArrayList<>();
    }

    public boolean takeFromAccount(double amount) {
        return deposit.takeAmount(amount);
    }

    public boolean addAmount (double amount) {
        return deposit.addAmount(amount);
    }

    public String getCustomerName() {
        return this.name;
    }

    public void accountInfo() {
        System.out.println("Name: " + this.name);
        deposit.accountInfo();
    }

}
