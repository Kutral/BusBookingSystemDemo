package com.teamproject.busmate.view;


import com.teamproject.busmate.service.BusService;

import java.util.Scanner;

public class AdminMenu {
    private final Scanner sc;
    private final BusService busService;

    public AdminMenu(Scanner sc, BusService busService) {
        this.sc = sc;
        this.busService = busService;
    }

    public void displayMenu() {
        while (true) {

            System.out.println("\nAdmin Menu");
            System.out.println("1. Add Bus");
            System.out.println("2. View All Buses");
            System.out.println("3.Search bus");
            System.out.println("4.Delete bus");
            System.out.println("5.Exit");
            System.out.println("Enter your choice: ");

            String choice = sc.next();
            switch (choice) {
                case "1":
                    busService.addBus();
                    break;
                case "2":
                    busService.viewAllBuses();
                    break;
                case "3":
                    busService.searchBus();
                    break;
                case "4":
                    busService.deleteBus();
                    break;
                case "5":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
