package com.teamproject.busmate.view;
import com.teamproject.busmate.Base.BaseView;
import com.teamproject.busmate.data.UserRepository;
import com.teamproject.busmate.service.AuthService;
import com.teamproject.busmate.service.BookingService;
import com.teamproject.busmate.service.BusService;

import java.util.Scanner;
public class WelcomeMenu extends BaseView {
    private final Scanner scanner;

    public WelcomeMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
       UserRepository userRepository = UserRepository.getInstance();
       AuthService authService = new AuthService(userRepository);
       BusService busService = new BusService();
       BookingService bookingService = new BookingService();
       LoginMenu loginMenu = new LoginMenu(scanner, authService, busService, bookingService);

       while(true){
           print("1. Login");
           print("2. Register");
           print("3. Exit");
           print("-----------------------------------------");
           print("Enter your choice: ");
           int choice = scanner.nextInt();
           switch (choice) {
               case 1:
                   loginMenu.displayLogin();
                   break;
               case 2:
                   loginMenu.displayRegister();
                   break;
               case 3:
                   print("Thank you for using BusMate");
                   print("-----------------------------------------");
                   System.exit(0);
               default:
                   print("Invalid choice. Please try again.");
                   break;
           }
       }
    }

}
