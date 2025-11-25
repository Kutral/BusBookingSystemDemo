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


    public AdminMenu(Scanner sc, BusService busService) {
        this.sc = sc;
        this.busService = busService;
    }

    public void displayMenu() {
        while (true) {

            printAll(constants.AdminMenu);

            String choice = sc.next();
            switch (choice) {
                case "1":
                    print("-----------------------------------------");
                    String busId = printQuestion("Enter Bus ID: ", sc);
                    String busNumber = printQuestion("Enter Bus Number: ", sc);
                    String busType = printQuestion("Enter Bus Type: ", sc);
                    String busName = printQuestion("Enter the Bus Name: ", sc);
                    print("-----------------------------------------");
                    if (busService.addBus(busId, busNumber, busType, busName) != null) {
                        print("Bus added successfully!");
                    }
                    break;
                case "2":
                    List<Bus> buses = busService.viewAllBuses();
                    print("\nAll Buses:");
                    print("-----------------------------------------");
                    for (Bus bus : buses) {
                        print("Bus ID: " + bus.getBusId() +
                                "  Bus Name: " + bus.getBusName() +
                                "  Bus Number: " + bus.getBusNumber() +
                                "  Type: " + bus.getBusType());
                    }
                    print("-----------------------------------------");
                    break;
                case "3":
                    print("-----------------------------------------");
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
                    print("-----------------------------------------");
                    break;
                case "4":
                    print("-----------------------------------------");
                    print("Enter the BusId");
                    String id = sc.next();
                    if (busService.deleteBus(id)) {
                        print("The Data was Deleted");
                    } else {
                        print("The bus was Not found");
                    }
                    print("-----------------------------------------");
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
