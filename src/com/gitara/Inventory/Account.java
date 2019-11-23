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
        if (amount > 0) {
            System.out.println("You succesfuly add " + amount + " on your account..");
        return true;
        }
        System.out.println("You can't add 0 or negative amount..");
    return false;
    }

    public boolean takeAmount (double amount) {
        if (!positiveAmount(amount)) {
            System.out.println("You can't take negative values from account..");
        return false;
        }
        deposit-=amount;
        System.out.println("You succesfuly took " + amount + " $.");
    return true;
    }

    public void accountInfo() {
        System.out.println("Your deposit: " + deposit);
    }

    private boolean positiveAmount(double amount) {
        return amount > 0;
    }

}
