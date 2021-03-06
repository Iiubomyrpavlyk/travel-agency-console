package com.liubomyr.voucher.model;

public class Hotel {

    private Integer ID;
    private String name;

    private String country;

    public Hotel(Integer ID, String name, String country) {
        this.ID = ID;
        this.name = name;
        this.country = country;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
