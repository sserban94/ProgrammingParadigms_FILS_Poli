package com.serbanscorteanu.tutorial1.classes;

public class DebitAccount extends Account {
    public DebitAccount(String IBAN) {
        super(IBAN);
    }

    @Override
    public boolean withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        if (amount > super.amount) {
            return false;
        }
        super.amount -= amount;
        return true;
    }
}
