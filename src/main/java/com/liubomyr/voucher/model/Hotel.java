package com.liubomyr.voucher.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name;
    private int stars;
    private Nutrition nutrition;
    private final List<Room> rooms;

    Hotel(String name, int stars, Nutrition nutrition, int rooms) {
        this.name = name;
        this.rooms = new ArrayList<>(rooms);
    }

    private class Room {
        int number;
        boolean isReserved;

        Room(int number, boolean isReserved) {
            this.number = number;
            this.isReserved = isReserved;
        }

        public int getNumber() {
            return number;
        }

        public boolean isReserved() {
            return isReserved;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "number=" + number +
                    ", isReserved=" + isReserved +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                ", nutrition=" + nutrition +
                ", rooms=" + rooms +
                '}';
    }
}
