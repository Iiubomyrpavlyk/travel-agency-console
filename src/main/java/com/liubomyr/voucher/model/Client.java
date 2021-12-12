package com.liubomyr.voucher.model;

import java.math.BigInteger;

public class Client {

    private Integer ID;

    private String firstName;
    private String lastName;

    private String email;
    private Integer passportCode;

    public Client(String firstName, String lastName, Integer passportCode, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportCode = passportCode;
        this.email = email;
    }

    public Client(Integer ID, String firstName, String lastName, Integer passportCode, String email) {
        this(firstName, lastName, passportCode, email);
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPassportCode() {
        return passportCode;
    }

    public void setPassportCode(Integer passportCode) {
        this.passportCode = passportCode;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}


