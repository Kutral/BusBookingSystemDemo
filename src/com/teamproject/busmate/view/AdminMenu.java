package com.teamproject.busmate.view;


import com.teamproject.busmate.Base.BaseView;
import com.teamproject.busmate.Constants.constants;
import com.teamproject.busmate.model.Bus;
import com.teamproject.busmate.service.BusService;

import java.util.List;
import java.util.Scanner;

public class AdminMenu extends BaseView {
    private final Scanner sc;
    private final BusService busService;
    private final constants Constants;

    public AdminMenu(Scanner sc, BusService busService, constants Constants) {
        this.sc = sc;
        this.busService = busService;
        this.Constants = Constants;
    }

    public void displayMenu() {
        while (true) {

            printAll(Constants.AdminMenu);

            String choice = sc.next();
            switch (choice) {
                case "1":

                    String busId = printQuestion("Enter Bus ID: ");
                    String busNumber = printQuestion("Enter Bus Number: ");
                    String busType = printQuestion("Enter Bus Type: ");
                    String busName = printQuestion("Enter the Bus Name: ");
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
