package com.serbanscorteanu.tutorial1.classes;

public class CreditAccount extends Account {

    private int maxCredit;

    public CreditAccount(String IBAN, int maxCredit) {
        super(IBAN);
        this.maxCredit = maxCredit;
    }

    @Override
    public boolean withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        if (amount > maxCredit) {
            return false;
        }
        super.amount -= amount;
        return true;
    }
}
