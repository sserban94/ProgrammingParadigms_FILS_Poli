package com.serbanscorteanu.tutorial1.classes;

import com.serbanscorteanu.tutorial1.customexceptions.StoreMethodException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClientTest {

    private Client client1;
    private Client client2;
    private Client client3;
    private Client client4;
    private Client client5;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testNames() {
        client1 = new Client("Serban", LocalDate.of(1950, 8, 22), "15...",
                new Address("Galati", 15, "Brailei"));
        client2 = new Client("Ion", LocalDate.of(1960, 8, 22), "16...",
                new Address("Galati", 15, "Brailei"));
        client3 = new Client("Maria", LocalDate.of(1940, 8, 22), "24...",
                new Address("Galati", 15, "Brailei"));
        client4 = new Client("Andrei", LocalDate.of(1970, 8, 22), "17...",
                new Address("Galati", 15, "Brailei"));
        assertTrue(client1.compareTo(client2) > 0,
                ("Clients with different names (" + client1.getName() + " - " + client2.getName() + ") are compared wrong "));
        assertTrue(client2.compareTo(client3) < 0,
                ("Clients with different names (" + client1.getName() + " - " + client2.getName() + ") are compared wrong "));
        assertTrue(client3.compareTo(client4) > 0,
                ("Clients with different names (" + client1.getName() + " - " + client2.getName() + ") are compared wrong "));
    }

    @Test
    public void testBirthday() {
        client1 = new Client("Serban", LocalDate.of(1950, 8, 22), "15...",
                new Address("Galati", 15, "Brailei"));
        client2 = new Client("Serban", LocalDate.of(1960, 8, 22), "16...",
                new Address("Galati", 15, "Brailei"));
        client3 = new Client("Serban", LocalDate.of(1940, 8, 22), "24...",
                new Address("Galati", 15, "Brailei"));
        client4 = new Client("Serban", LocalDate.of(1970, 8, 22), "17...",
                new Address("Galati", 15, "Brailei"));
        assertTrue(client1.compareTo(client2) > 0,
                ("Clients with different birthdays (" + client1.getBday() + " - " + client2.getBday() + ") are compared wrong "));
        assertTrue(client2.compareTo(client3) < 0,
                ("Clients with different birthdays (" + client2.getBday() + " - " + client3.getBday() + ") are compared wrong "));
        assertTrue(client3.compareTo(client4) > 0,
                ("Clients with different birthdays (" + client3.getBday() + " - " + client4.getBday() + ") are compared wrong "));
    }

    @Test
    public void testGenderUsingCNP() {
        client1 = new Client("Serban", LocalDate.of(1950, 8, 22), "15...",
                new Address("Galati", 15, "Brailei"));
        client2 = new Client("Serban", LocalDate.of(1950, 8, 22), "16...",
                new Address("Galati", 15, "Brailei"));
        client3 = new Client("Serban", LocalDate.of(1950, 8, 22), "24...",
                new Address("Galati", 15, "Brailei"));
        client4 = new Client("Serban", LocalDate.of(1950, 8, 22), "17...",
                new Address("Galati", 15, "Brailei"));
        assertTrue(client1.compareTo(client3) < 0,
                ("Clients with different genders (" + client1.getCNP() + " - " + client3.getCNP() + ") are compared wrong "));
        assertTrue(client2.compareTo(client3) < 0,
                ("Clients with different genders (" + client2.getCNP() + " - " + client3.getCNP() + ") are compared wrong "));
        assertTrue(client4.compareTo(client3) < 0,
                ("Clients with different genders (" + client4.getCNP() + " - " + client3.getCNP() + ") are compared wrong "));
    }

    @Test
    public void testGenderUsingGender() {
        client1 = new Client("Serban", LocalDate.of(1950, 8, 22), "15...",
                new Address("Galati", 15, "Brailei"), "M", 176);
        client2 = new Client("Serban", LocalDate.of(1950, 8, 22), "16...",
                new Address("Galati", 15, "Brailei"), "M", 176);
        client3 = new Client("Serban", LocalDate.of(1950, 8, 22), "24...",
                new Address("Galati", 15, "Brailei"), "F", 176);
        client4 = new Client("Serban", LocalDate.of(1950, 8, 22), "17...",
                new Address("Galati", 15, "Brailei"), "M", 176);
        assertTrue(client1.compareTo(client3) < 0,
                ("Clients with different genders (" + client1.getCNP() + " - " + client3.getCNP() + ") are compared wrong "));
        assertTrue(client2.compareTo(client3) < 0,
                ("Clients with different genders (" + client2.getCNP() + " - " + client3.getCNP() + ") are compared wrong "));
        assertTrue(client4.compareTo(client3) < 0,
                ("Clients with different genders (" + client4.getCNP() + " - " + client3.getCNP() + ") are compared wrong "));
    }

    @Test
    public void testHeight() {
        client1 = new Client("Serban", LocalDate.of(1950, 8, 22), "15...",
                new Address("Galati", 15, "Brailei"), "M", 176);
        client2 = new Client("Serban", LocalDate.of(1950, 8, 22), "15...",
                new Address("Galati", 15, "Brailei"), "M", 190);
        client3 = new Client("Serban", LocalDate.of(1950, 8, 22), "15...",
                new Address("Galati", 15, "Brailei"), "M", 150);
        client4 = new Client("Serban", LocalDate.of(1950, 8, 22), "15...",
                new Address("Galati", 15, "Brailei"), "M", 185);
        assertTrue(client1.compareTo(client3) > 0,
                ("Clients with different heights (" + client1.getHeight() + " - " + client3.getHeight() + ") are compared wrong "));
        assertTrue(client2.compareTo(client3) > 0,
                ("Clients with different genders (" + client2.getHeight() + " - " + client3.getHeight() + ") are compared wrong "));
        assertTrue(client4.compareTo(client3) > 0,
                ("Clients with different genders (" + client4.getHeight() + " - " + client3.getHeight() + ") are compared wrong "));
    }

    @Test
    public void testStoreMethodWithInvalidFilename() {
        String expectedExceptionMessage = "A crapat metoda store";
        String invalidFilename = "";
        String validFilename = "test-interface-method.txt";
        Client client1 = new Client("Serban", LocalDate.of(1950, 8, 22), "15...",
                new Address("Galati", 15, "Brailei"), "M", 176);
        client1.addAccount(new DebitAccount("RO49 AAAA 1B31 0075 9384 0000"));
        client1.addAccount(new CreditAccount("RO00 AAAA 1B31 0075 9384 0000", 30000));
        Client client2 = new Client("Ion", LocalDate.of(1960, 8, 22), "16...",
                new Address("Galati", 15, "Brailei"));
        client2.addAccount(new DebitAccount("RO00 AAAA AABB 0075 9384 0000"));
        client2.addAccount(new CreditAccount("RO00 AAAA 1B31 0075 9384 0000", 10000));
        client2.addAccount(new CreditAccount("RO00 AAAA BBBB 0075 9384 9999", 25000));
        StoreMethodException sme = assertThrows(StoreMethodException.class, () -> client1.store(invalidFilename));
        assertEquals(expectedExceptionMessage, sme.getMessage());
    }

    @Test
    public void testStoreMethodShouldCreateFile() throws StoreMethodException, IOException {
        String validFilename = "test-interface-method.txt";
        Client client1 = new Client("Serban", LocalDate.of(1950, 8, 22), "15...",
                new Address("Galati", 15, "Brailei"), "M", 176);
        client1.addAccount(new DebitAccount("RO49 AAAA 1B31 0075 9384 0000"));
        client1.addAccount(new CreditAccount("RO00 AAAA 1B31 0075 9384 0000", 30000));
        Client client2 = new Client("Ion", LocalDate.of(1960, 8, 22), "16...",
                new Address("Galati", 15, "Brailei"));
        client2.addAccount(new DebitAccount("RO00 AAAA AABB 0075 9384 0000"));
        client2.addAccount(new CreditAccount("RO00 AAAA 1B31 0075 9384 0000", 10000));
        client2.addAccount(new CreditAccount("RO00 AAAA BBBB 0075 9384 9999", 25000));
        Path filePath = Path.of(validFilename);
        client1.store(validFilename);
        assertTrue(Files.exists(filePath), "File was not created");
        Files.delete(filePath);
    }



}