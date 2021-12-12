package com.liubomyr.voucher.model;

import java.util.Date;

public class Voucher {

    private Client client;
    private VoucherType voucherType;

    private Transport transport;

    private Hotel hotel;
    private Country country;

    private Nutrition nutrition;

    private Date arrivalDate;
    private Date departureDate;

    private Cost cost;

    public Voucher(Client client, VoucherType voucherType, Country country, Hotel hotel, Transport transport, Nutrition nutrition, Date arrivalDate, Date departureDate) {
        this.client = client;
        this.voucherType = voucherType;
        this.country = country;
        this.hotel = hotel;
        this.transport = transport;
        this.arrivalDate = arrivalDate;
        this.nutrition = nutrition;
        this.departureDate = departureDate;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public VoucherType getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(VoucherType voucherType) {
        this.voucherType = voucherType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }
}

