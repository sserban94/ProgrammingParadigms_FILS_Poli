package com.serbanscorteanu.tutorial1.main;

import com.serbanscorteanu.tutorial1.classes.Address;
import com.serbanscorteanu.tutorial1.classes.Client;
import com.serbanscorteanu.tutorial1.classes.CreditAccount;
import com.serbanscorteanu.tutorial1.classes.DebitAccount;
import com.serbanscorteanu.tutorial1.customexceptions.StoreMethodException;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Serban", LocalDate.of(1950, 8, 22), "15...",
                new Address("Galati", 15, "Brailei"), "M", 176);
        client1.addAccount(new DebitAccount("RO49 AAAA 1B31 0075 9384 0000"));
        client1.addAccount(new CreditAccount("RO00 AAAA 1B31 0075 9384 0000", 30000));
        Client client2 = new Client("Ion", LocalDate.of(1960, 8, 22), "16...",
                new Address("Galati", 15, "Brailei"));
        client2.addAccount(new DebitAccount("RO00 AAAA AABB 0075 9384 0000"));
        client2.addAccount(new CreditAccount("RO00 AAAA 1B31 0075 9384 0000", 10000));
        client2.addAccount(new CreditAccount("RO00 AAAA BBBB 0075 9384 9999", 25000));
        System.out.println(client1);
        System.out.println();
        System.out.println(client2);
        try{
            client1.store("test-interface-method.txt");
            client2.store("test-interface-method.txt");
        } catch(StoreMethodException sme) {
            sme.printStackTrace();
        }
    }
}
