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
    public Bus searchBusById(String id) {
        for (Bus bus : buses) {
            if (bus.getBusId() .equals(id)) {
                return bus;
            }
        }
        return null;
    }
    public void deleteBus(String id){
        for (Bus bus : buses) {
            if (bus.getBusId() .equals(id)) {
                buses.remove(bus);
                System.out.println("The Data was Deleted");
                return;
            }
        }
        System.out.println("The bus was Not found");
    }
}
