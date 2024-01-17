package com.serbanscorteanu.ex2;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("BLA-BLA-BLA-BLA", 100);
        BankAccount bankAccount2 = new BankAccount("BLEAH-BLEAH-BLEAH-BLEAH", 200);
        BankAccount bankAccount3 = new BankAccount("OF-OF-OF-OF-OF", 500);

        Thread thread = new Thread(() -> {
            // maybe i should try a loop and some prints here
            for (int i = 0; i < 100; i++){
                bankAccount.deposit(1000);
                System.out.println("bankAccount - Current total balance: " + bankAccount.getTotalBalance());
                bankAccount2.deposit(1000);
                System.out.println("bankAccount2 - Current total balance: " + bankAccount2.getTotalBalance());
                bankAccount3.deposit(1000);
                System.out.println("bankAccount3 - Current total balance: " + bankAccount3.getTotalBalance());
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++){
                bankAccount.withdraw(500);
                System.out.println("bankAccount - Current total balance: " + bankAccount.getTotalBalance());
                bankAccount2.withdraw(400);
                System.out.println("bankAccount2 - Current total balance: " + bankAccount2.getTotalBalance());
                bankAccount3.withdraw(300);
                System.out.println("bankAccount3 - Current total balance: " + bankAccount3.getTotalBalance());
            }
        });
        thread.start();
        thread2.start();
    }
}
