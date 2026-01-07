package com.teamproject.busmate.model;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    private final String busId;
    private final String busNumber;
    private  String busType;
    private  String busName;
    private  String busFrom;
    private  String busTo;
    private  int capacity;
    private  double price;
    private  final List<Seat> seats;

    public Bus(String busId, String busNumber, int capacity, double price) {
        this.busId = busId;
        this.busNumber = busNumber;
        this.capacity = capacity;
        this.price = price;
        this.seats = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            this.seats.add(new Seat(i));
        }
    }
    public String getBusId() {
        return busId;
    }
    public String getBusNumber() {
        return busNumber;
    }

    public String getBusType() {
        return busType;
    }
    public void setBusType(String s) {
        busType = s;
    }

    public String getBusName() {
        return busName;
    }
    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusFrom() {
        return busFrom;
    }
    public void setBusFrom(String s) {
        busFrom = s;
    }
    public String getBusTo() {
        return busTo;
    }
    public void setBusTo(String s) {
        busTo = s;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        // logic to resize seats if needed, but for simplicity we'll assume capacity is set at creation
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Seat> getSeats() {
        return seats;
    }

}
