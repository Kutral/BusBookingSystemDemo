package com.teamproject.busmate.view;
import com.teamproject.busmate.data.UserRepository;
import com.teamproject.busmate.service.AuthService;
import com.teamproject.busmate.service.BookingService;
import com.teamproject.busmate.service.BusService;

import java.util.Scanner;
public class WelcomeMenu {
    public void displayMenu() {
       UserRepository userRepository = UserRepository.getInstance();
       AuthService authService = new AuthService(userRepository);
       BusService busService = new BusService();
       BookingService bookingService = new BookingService();
       LoginMenu loginMenu = new LoginMenu(authService, busService, bookingService);
       Scanner scanner = new Scanner(System.in);

       while(true){
           System.out.println("1. Login");
           System.out.println("2. Register");
           System.out.println("3. Exit");
           System.out.println("Enter your choice: ");
           int choice = scanner.nextInt();
           switch (choice) {
               case 1:
                   loginMenu.displayLogin();
                   break;
               case 2:
                   loginMenu.displayRegister();
                   break;
               case 3:
                   System.out.println("Thank you for using BusMate");
                   System.exit(0);
               default:
                   System.out.println("Invalid choice. Please try again.");
                   break;
           }
       }
    }

}
