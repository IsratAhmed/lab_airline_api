package com.example.airline_api.models;

public class Booking {

    private long passengerId;

    public Booking(long passengerId) {
        this.passengerId = passengerId;
    }

    public Booking() {
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }
}
