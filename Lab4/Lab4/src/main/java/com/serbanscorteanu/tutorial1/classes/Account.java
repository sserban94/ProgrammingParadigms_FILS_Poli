package com.serbanscorteanu.tutorial1.classes;

public abstract class Account implements Comparable<Account> {
    protected String IBAN;
    protected int amount;

    public Account(String IBAN) {
        this.IBAN = IBAN;
    }

    public abstract boolean withdraw(int amount);

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        this.amount += amount;
    }

    @Override
    public int compareTo(Account otherAccount) {
        // check references
        if (this == otherAccount) {
            return 0;
        }
        if (this.amount != otherAccount.amount) {
            return this.amount - otherAccount.amount;
        }

        return this.IBAN.compareTo(otherAccount.IBAN);
    }
}
