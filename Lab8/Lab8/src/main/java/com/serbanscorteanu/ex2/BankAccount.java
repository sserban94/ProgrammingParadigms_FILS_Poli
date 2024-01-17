package com.serbanscorteanu.ex2;

public class BankAccount {
    private String accountIBAN;


    private int totalBalance;

    public BankAccount(String accountIBAN, int startingBalance) {
        this.accountIBAN = accountIBAN;
        this.totalBalance = startingBalance;
    }

    public synchronized boolean deposit(int amount) {
        if (amount <= 0) {
//            throw new IllegalArgumentException();
            return false;
        }
        this.totalBalance += amount;
        return true;
    }

    public synchronized boolean withdraw(int amount) {
        if (amount <= 0) {
//            throw new IllegalArgumentException();
            return false;
        }
        if (totalBalance < amount) {
//            throw new IllegalArgumentException();
            return false;
        }
        this.totalBalance -= amount;
        return true;
    }

    public String getAccountIBAN() {
        return accountIBAN;
    }

    public void setAccountIBAN(String accountIBAN) {
        this.accountIBAN = accountIBAN;
    }

    public int getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(int totalBalance) {
        this.totalBalance = totalBalance;
    }
}
