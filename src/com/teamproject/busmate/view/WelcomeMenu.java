package com.teamproject.busmate.view;
import com.teamproject.busmate.Base.BaseView;
import com.teamproject.busmate.Constants.constants;
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
           printAll(constants.WelcomeMenu);
           int choice = scanner.nextInt();
           switch (choice) {
               case 1:
                   loginMenu.displayLogin();
                   break;
               case 2:
                   loginMenu.displayRegister();
                   break;
               case 3:
                   print(constants.ThankYouMessage);
                   print("-----------------------------------------");
                   System.exit(0);
               default:
                   print(constants.InvalidChoiceMessage);
                   break;
           }
       }
    }

}
