package com.serbanscorteanu.tutorial1.classes;

import com.serbanscorteanu.tutorial1.customexceptions.StoreMethodException;
import com.serbanscorteanu.tutorial1.interfaces.Storable;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client implements Comparable<Client>, Storable {
    private String name;
    private LocalDate bday;
    private String CNP;
    private Address address;
    private List<Account> accounts;

    private String gender = "";
    private int height;

    public Client(String name, LocalDate bday, String CNP, Address address) {
        this.name = name;
        this.bday = bday;
        this.CNP = CNP;
        this.address = address;
        this.accounts = new ArrayList<>();
    }

    public Client(String name, LocalDate bday, String CNP, Address address, String gender, int height) {
        this.name = name;
        this.bday = bday;
        this.CNP = CNP;
        this.address = address;
        this.accounts = new ArrayList<>();
        this.gender = gender;
        this.height = height;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public boolean removeAccount(String IBAN) {
        for (Account a : this.accounts) {
            if (a.IBAN.equals(IBAN)) {
                return this.accounts.remove(a);
            }
        }
        return false;
    }

    @Override
    public int compareTo(Client otherClient) {
        if (this == otherClient) {
            return 0;
        }
//        if (this.name.compareTo(otherClient.name) == 0) {
//            if (this.bday.compareTo(otherClient.bday) == 0) {
//                if (this.gender.compareTo(otherClient.gender) == 0) {
//                    if (this.height > otherClient.height) {
//                        return 1;
//                    } else if (this.height == otherClient.height) {
//                        return 0;
//                    } else {
//                        return -1;
//                    }
//                } else {
//                    return this.gender.compareTo(otherClient.gender);
//                }
//            } else {
//                return this.bday.compareTo(otherClient.bday);
//            }
//        }
//        else {
//            return this.name.compareTo(otherClient.name);
//        }
        int nameComparison = this.name.compareTo(otherClient.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        // Need to negative this one as I want the older person to be greater than the younger one
        int birthdayComparison = -this.bday.compareTo(otherClient.bday);
        if (birthdayComparison != 0) {
            return birthdayComparison;
        }
//        int genderComparison = this.gender.compareTo(otherClient.gender);
//        if (genderComparison != 0) {
//            return genderComparison;
//        }
//        TODO - the previous one could be computed using the CNP and no gender field would be req anymore
//        assuming ofc that the CNPs respect the valid format
        int genderComparisonUsingCNP = this.CNP.compareTo(otherClient.CNP);
        if (genderComparisonUsingCNP != 0) {
            return genderComparisonUsingCNP;
        }
        return this.height - otherClient.height;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBday() {
        return bday;
    }

    public String getCNP() {
        return CNP;
    }

    public String getGender() {
        return gender;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ");
        stringBuilder.append(this.name);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Birthday: ");
        stringBuilder.append(this.bday);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("CNP: ");
        stringBuilder.append(this.CNP);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Address: ");
        stringBuilder.append(this.address);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Accounts: ");
        if (!this.accounts.isEmpty()) {
            stringBuilder.append(System.lineSeparator());
        }
        for (Account a : this.accounts) {
            stringBuilder.append("IBAN: ");
            stringBuilder.append(a.IBAN);
            stringBuilder.append(System.lineSeparator());
        }
        if (this.accounts.isEmpty()){
            stringBuilder.append(System.lineSeparator());
        }
        if (this.gender.isEmpty()) {
            stringBuilder.append("Gender from CNP: ");
            if (this.CNP.charAt(0) == 1) {
                stringBuilder.append("Male");
            } else {
                stringBuilder.append("Female");
            }
        } else {
            stringBuilder.append("Gender: ");
            stringBuilder.append(this.gender);
        }
        stringBuilder.append(System.lineSeparator());
        if (this.height == 0) {
            stringBuilder.append("Height not specified");
        } else {
            stringBuilder.append("Height: ");
            stringBuilder.append(this.height);
        }
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    @Override
    public void store(String file) throws StoreMethodException {
        // try with resources
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file,true));) {
            printWriter.print(this);
            printWriter.println();
            printWriter.flush();
        } catch (IOException e) {
//            throw new RuntimeException(e);
            throw new StoreMethodException("A crapat metoda store");
        }
    }
}
