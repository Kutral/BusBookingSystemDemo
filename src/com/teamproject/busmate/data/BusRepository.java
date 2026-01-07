package com.teamproject.busmate.data;

import com.teamproject.busmate.model.Bus;

import java.util.ArrayList;
import java.util.List;

public class BusRepository {
    private static final BusRepository instance = new BusRepository();
    private final List<Bus> buses = new ArrayList<>();

    private BusRepository() {}

    public static BusRepository getInstance() {
        return instance;
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public List<Bus> getAllBuses() {
        return new ArrayList<>(buses);
    }
    public Bus searchBusById(String id) {
        for (Bus bus : buses) {
            if (bus.getBusId() .equals(id)) {
                return bus;
            }
        }
        return null;
    }
    public boolean deleteBus(String id){
        for (Bus bus : buses) {
            if (bus.getBusId() .equals(id)) {
                buses.remove(bus);
                return true;
            }
        }
        return false;
    }
}
