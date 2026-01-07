package com.teamproject.busmate.service;


import com.teamproject.busmate.data.BusRepository;
import com.teamproject.busmate.model.Bus;

import java.util.ArrayList;
import java.util.List;

public class BusService {

    private BusRepository busRepo = BusRepository.getInstance();

    public Bus addBus(String busId, String busNumber, String busType, String busName, String from, String to, int capacity, double price) {
        Bus bus = new Bus(busId, busNumber, capacity, price);
        bus.setBusType(busType);
        bus.setBusName(busName);
        bus.setBusFrom(from);
        bus.setBusTo(to);
        busRepo.addBus(bus);
        return bus;
    }


    public List<Bus> viewAllBuses() {
        return busRepo.getAllBuses();
    }

    public Bus searchBus(String id) {
        return busRepo.searchBusById(id);
    }
    
    public List<Bus> searchBus(String from, String to) {
        List<Bus> allBuses = busRepo.getAllBuses();
        List<Bus> result = new ArrayList<>();
        for (Bus bus : allBuses) {
            if (bus.getBusFrom().equalsIgnoreCase(from) && bus.getBusTo().equalsIgnoreCase(to)) {
                result.add(bus);
            }
        }
        return result;
    }

    public boolean deleteBus(String id) {
        return busRepo.deleteBus(id);
    }
}

