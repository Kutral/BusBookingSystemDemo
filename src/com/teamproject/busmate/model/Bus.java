package com.teamproject.busmate.model;

public class Bus {

    private final String busId;
    private final String busNumber;
    private  String busType;
    private  String busName;
    private  String busFrom;
    private  String busTo;

    public Bus(String busId, String busNumber) {
        this.busId = busId;
        this.busNumber = busNumber;

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

}
