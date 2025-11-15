package com.teamproject.busmate.data;

import com.teamproject.busmate.model.Bus;

import java.util.ArrayList;
import java.util.List;

public class BusRepository {

    private final List<Bus> buses = new ArrayList<>();


    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public List<Bus> getAllBuses() {
        return new ArrayList<>(buses);
    }
}
