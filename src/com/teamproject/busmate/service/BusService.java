package com.teamproject.busmate.service;


import com.teamproject.busmate.data.BusRepository;
import com.teamproject.busmate.model.Bus;

import java.util.List;
import java.util.Scanner;

public class BusService {

    private BusRepository busRepo = new BusRepository();
    Scanner sc = new Scanner(System.in);

    public void addBus() {

        System.out.println("Enter Bus ID: ");
        String busId = sc.next();

        System.out.println("Enter Bus Number: ");
        String busNumber = sc.next();

        System.out.println("Enter Bus Type: A/C or Non A/C ");
        String busType = sc.next();

        System.out.println("Enter the Starting Point");
        String busStart = sc.next();

        System.out.println("Enter the End point");
        String busTo = sc.next();

        System.out.println("Enter the Bus Name");
        String busName = sc.next();

        Bus bus = new Bus(busId, busNumber);

        bus.setBusType(busType);
        bus.setBusName(busName);
        bus.setBusFrom(busStart);
        bus.setBusTo(busTo);

        busRepo.addBus(bus);
        System.out.println("Bus added successfully!");
    }

    public void busData(Bus bus) {
        System.out.println("Bus ID: " + bus.getBusId() +
                "  Bus Name: " + bus.getBusName() +
                "  Number: " + bus.getBusNumber() +
                "  Type: " + bus.getBusType() +
                "  From : " + bus.getBusFrom() +
                "  To : " + bus.getBusTo());
    }

    public void viewAllBuses() {
        List<Bus> buses = busRepo.getAllBuses();
        System.out.println("\nAll Buses:");
        for (Bus bus : buses) {

            System.out.println("Bus ID: " + bus.getBusId() +
                    "  Bus Name: " + bus.getBusName() +
                    "  Number: " + bus.getBusNumber() +
                    "  Type: " + bus.getBusType() +
                    "  From : " + bus.getBusFrom() +
                    "  To : " + bus.getBusTo());

            System.out.println("Arey Bhai");
            busData(bus);
        }

    }
//    public void searchBus() {
//        System.out.println("Enter the BusId");
//        int id = sc.nextInt();
//        busRepo.searchBus(id);
//    }
//    public void searchBus(int id) {
//        for (Bus bus : buses) {
//            if (bus.getBusId() .equals(id)) {
//                b.busData(bus);
//            }
//        }
//        b.busData(null);          // Not found
//    }
}

