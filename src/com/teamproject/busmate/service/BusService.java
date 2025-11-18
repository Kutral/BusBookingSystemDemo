package com.teamproject.busmate.service;


import com.teamproject.busmate.data.BusRepository;
import com.teamproject.busmate.model.Bus;

import java.util.List;

public class BusService {

    private BusRepository busRepo = new BusRepository();

    public Bus addBus(String busId, String busNumber, String busType, String busName) {
        Bus bus = new Bus(busId, busNumber);
        bus.setBusType(busType);
        bus.setBusName(busName);
        busRepo.addBus(bus);
        return bus;
    }


    public List<Bus> viewAllBuses() {
        return busRepo.getAllBuses();
    }

    public Bus searchBus(String id) {
        return busRepo.searchBusById(id);
    }
    public boolean deleteBus(String id) {
        return busRepo.deleteBus(id);
    }
}

