package com.teamproject.busmate.view;


import com.teamproject.busmate.model.Bus;
import com.teamproject.busmate.service.BusService;

import java.util.List;
import java.util.Scanner;

public class AdminMenu extends BaseView {
    private final Scanner sc;
    private final BusService busService;

    public AdminMenu(Scanner sc, BusService busService) {
        this.sc = sc;
        this.busService = busService;
    }

    public void displayMenu() {
        while (true) {
            print("-----------------------------------------");
            print("\nAdmin Menu");
            print("1. Add Bus");
            print("2. View All Buses");
            print("3.Search bus");
            print("4.Delete bus");
            print("5.Exit");
            print("-----------------------------------------");
            print("Enter your choice: ");

            String choice = sc.next();
            switch (choice) {
                case "1":
                    print("Enter Bus ID: ");
                    String busId = sc.next();
                    print("Enter Bus Number: ");
                    String busNumber = sc.next();
                    print("Enter Bus Type: A/C or Non-A/C ");
                    String busType = sc.next();
                    print("Enter the Bus Name");
                    String busName = sc.next();
                    if (busService.addBus(busId, busNumber, busType, busName) != null) {
                        print("Bus added successfully!");
                    }
                    break;
                case "2":
                    List<Bus> buses = busService.viewAllBuses();
                    print("\nAll Buses:");
                    for (Bus bus : buses) {
                        print("Bus ID: " + bus.getBusId() +
                                "  Bus Name: " + bus.getBusName() +
                                "  Bus Number: " + bus.getBusNumber() +
                                "  Type: " + bus.getBusType());
                    }
                    break;
                case "3":
                    print("Enter the BusId");
                    String searchId = sc.next();
                    Bus bus = busService.searchBus(searchId);
                    if (bus != null) {
                        print("Bus ID: " + bus.getBusId() +
                                "  Bus Name: " + bus.getBusName() +
                                "  Bus Number: " + bus.getBusNumber() +
                                "  Type: " + bus.getBusType());
                    } else {
                        print("The Entered Bus is not Availble");
                    }
                    break;
                case "4":
                    print("Enter the BusId");
                    String id = sc.next();
                    if (busService.deleteBus(id)) {
                        print("The Data was Deleted");
                    } else {
                        print("The bus was Not found");
                    }
                    break;
                case "5":
                    print("Logging out...");
                    return;
                default:
                    print("Invalid choice. Please try again.");
            }
        }
    }
}
