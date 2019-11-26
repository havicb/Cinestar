package com.gitara.Inventory;

public class Account {
    private double deposit;

    public Account() {
        this(0.00);
    }

    public Account(double deposit) {
        if (positiveAmount(deposit))
            this.deposit = deposit;
        else
            this.deposit = 0;
    }

    public boolean addAmount (double amount) {
        deposit += positiveAmount(amount) ? amount : 0;
        return amount > 0;
    }

    public boolean takeAmount (double amount) {
        if (amount > deposit)
            return false;
        deposit-=amount;
    return true;
    }

    public void accountInfo() {
        System.out.println("Your deposit: " + deposit);
    }

    private boolean positiveAmount(double amount) {
        return amount > 0;
    }

}
